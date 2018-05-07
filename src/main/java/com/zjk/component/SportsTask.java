package com.zjk.component;

import com.zjk.common.DefSportsData;
import com.zjk.entity.SportsStatisticsData;
import com.zjk.entity.SportsTypeData;
import com.zjk.entity.SportsSuggestion;
import com.zjk.entity.UserInfo;
import com.zjk.service.SportsService;
import com.zjk.service.UserService;
import com.zjk.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class SportsTask {

	@Autowired
	private UserService userService;

	@Autowired
	private SportsService sportsService;

//	private static final String CRON = "0 0 24 ? * SUN";
	private static final String CRON = "*/10 * * * * *";

	private boolean bool = true;

	@Scheduled(cron = CRON)
	public void generateSportsSuggestion() {
		if (!bool) {
			return;
		}
		bool = false;
		System.out.println("============task start: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "============");
		ArrayList<UserInfo> userInfos = userService.queryAll();
		if (userInfos == null) {
			return;
		}
		for (UserInfo userInfo : userInfos) {
			ArrayList<SportsStatisticsData> sportsStatisticsData = sportsService.querySportsStatisticsDataByUId(userInfo.getuId());
			if (sportsStatisticsData == null) {
				sportsStatisticsData = new ArrayList<SportsStatisticsData>();
			}
			insertSuggestion(userInfo, sportsStatisticsData);
		}
	}

	private void insertSuggestion(UserInfo userInfo, List<SportsStatisticsData> sportsStatisticsDatas) {
		int[] days = statisticsDays(sportsStatisticsDatas);
		List<SportsSuggestion> sportsSuggestions = new ArrayList<SportsSuggestion>(days.length);
		Map<Integer, SportsTypeData> map = statisticsTypeData(sportsStatisticsDatas);
		int[] types = statisticsTypes(days.length, map);
		SportsTypeData sportsTypeData;
		for (int i = 0; i < days.length; i++) {
			sportsTypeData = map.get(types[i]);
			if (sportsTypeData == null) {
				sportsTypeData = new SportsTypeData();
				sportsTypeData.setType(types[i]);
				initSportsTypeData(sportsTypeData);
			}
			SportsSuggestion suggestion = new SportsSuggestion();
			suggestion.setuId(userInfo.getuId());
			suggestion.setStartTime(DateUtil.getDateByDays(days[i]));
			suggestion.setType(types[i]);
			suggestion.setUsedTime(sportsTypeData.getAverUsedTime());
			suggestion.setDistance(sportsTypeData.getAverDistance());

			sportsSuggestions.add(suggestion);
		}
		adjustSuggestion(userInfo, sportsSuggestions);
		for (SportsSuggestion suggestion : sportsSuggestions) {
			sportsService.insertSportsSuggestion(suggestion);
		}
	}

	/**
	 * 当数据比较少的情况下，初始化数据
	 *
	 * @param sportsTypeData data
	 */
	private void initSportsTypeData(SportsTypeData sportsTypeData) {
		switch (sportsTypeData.getType()) {
			case DefSportsData.SPORTS_TYPE_WALK:
				sportsTypeData.setAverUsedTime(20);
				sportsTypeData.setAverDistance(1);
				break;
			case DefSportsData.SPORTS_TYPE_RUN:
				sportsTypeData.setAverUsedTime(20);
				sportsTypeData.setAverDistance(2);
				break;
			case DefSportsData.SPORTS_TYPE_RIDING:
				sportsTypeData.setAverUsedTime(30);
				sportsTypeData.setAverDistance(5);
				break;
			case DefSportsData.SPORTS_TYPE_SKATING:
				sportsTypeData.setAverUsedTime(30);
				sportsTypeData.setAverDistance(5);
				break;
			default:
				sportsTypeData.setAverUsedTime(20);
				sportsTypeData.setAverDistance(2);
				break;
		}
	}

	/**
	 * 根据用户的身体信息对运动建议进行调整
	 *
	 * @param userInfo          UserInfo
	 * @param sportsSuggestions list
	 */
	private void adjustSuggestion(UserInfo userInfo, List<SportsSuggestion> sportsSuggestions) {
		int BMI = Math.round((float) userInfo.getWeight() / ((float) userInfo.getHeight() * userInfo.getHeight() / 10000.0f));
		int age = DateUtil.getAge(userInfo.getBirthday());
		double percentageBMI;
		double percentageAge;
		if (userInfo.getGender() == 1) { // 女
			if (BMI < 19) {
				percentageBMI = 0.90d;
			} else if (BMI <= 24) {
				percentageBMI = 1.10d;
			} else if (BMI <= 29) {
				percentageBMI = 0.95d;
			} else if (BMI <= 34) {
				percentageBMI = 0.90d;
			} else {
				percentageBMI = 0.85d;
			}

			if (age < 10) {
				percentageAge = 0.70;
			} else if (age <= 12) {
				percentageAge = 0.80d;
			} else if (age <= 15) {
				percentageAge = 0.90d;
			} else if (age <= 22) {
				percentageAge = 1.00d;
			} else if (age <= 30) {
				percentageAge = 1.10d;
			} else if (age <= 65) {
				percentageAge = 1.10d - ((age - 30) / 10 + 1) * 0.15d;
			} else {
				percentageAge = 0.2;
			}

		} else { // 男，性别保密的当男的处理
			if (BMI < 20) {
				percentageBMI = 0.90d;
			} else if (BMI <= 25) {
				percentageBMI = 1.10d;
			} else if (BMI <= 30) {
				percentageBMI = 0.95d;
			} else if (BMI <= 35) {
				percentageBMI = 0.90d;
			} else {
				percentageBMI = 0.85d;
			}

			if (age < 10) {
				percentageAge = 0.70;
			} else if (age <= 13) {
				percentageAge = 0.80d;
			} else if (age <= 17) {
				percentageAge = 0.90d;
			} else if (age <= 24) {
				percentageAge = 1.00d;
			} else if (age <= 32) {
				percentageAge = 1.10d;
			} else if (age <= 65) {
				percentageAge = 1.10d - ((age - 30) / 10 + 1) * 0.15d;
			} else {
				percentageAge = 0.2;
			}
		}

		for (SportsSuggestion suggestion : sportsSuggestions) {
			suggestion.setUsedTime(Math.round(suggestion.getUsedTime() * percentageBMI * percentageAge));
			suggestion.setDistance(Math.round(suggestion.getDistance() * percentageBMI * percentageAge));
		}
	}

	/**
	 * 计算出周几会去运动
	 *
	 * @param sportsStatisticsDatas list
	 * @return 返回会去运动的日期，可有多个
	 */
	private int[] statisticsDays(List<SportsStatisticsData> sportsStatisticsDatas) {
		int[] dayTimes = new int[DefSportsData.DAY_OF_WEEK];
		for (int i = 0; i < DefSportsData.DAY_OF_WEEK; i++) {
			dayTimes[i] = 0;
		}
		for (SportsStatisticsData sportsStatisticsData : sportsStatisticsDatas) {
			dayTimes[sportsStatisticsData.getDay() - 1] += sportsStatisticsData.getTimes();
		}
		int exceedAverDays = 0; // 超过平均数的天数
		int sum = 0;
		for (int i = 0; i < DefSportsData.DAY_OF_WEEK; i++) {
			sum += dayTimes[i];
		}
		double averTimes = (double) sum / (double) DefSportsData.DAY_OF_WEEK;
		for (int i = 0; i < DefSportsData.DAY_OF_WEEK; i++) {
			if (dayTimes[i] > averTimes) {
				exceedAverDays++;
			}
		}
		int days[];
		if (exceedAverDays > 0) { // 平均数大于0的话，就直接采取超过平均数的个数
			days = new int[exceedAverDays];
			int index = 0;
			for (int i = 0; i < DefSportsData.DAY_OF_WEEK; i++) {
				if (dayTimes[i] >= averTimes) {
					days[index++] = i + 1;
				}
			}
			return days;
		}
		days = new int[DefSportsData.DEFAULT_SUGGESTION_DAYS]; // 假设用户之前没有数据，则默认推荐周三、周六
		days[0] = 4;
		days[1] = 7;

		return days;
	}

	/**
	 * 计算出最有可能得集中运动类型
	 *
	 * @param length int
	 * @param map    map
	 * @return int[]
	 */
	private int[] statisticsTypes(int length, Map<Integer, SportsTypeData> map) {
		int[] types = new int[length];
		Set<Integer> set = map.keySet();
		int[] array = new int[set.size()];
		Iterator<Integer> iterable = set.iterator();
		int index = 0;
		while (iterable.hasNext()) {
			array[index++] = iterable.next();
		}
		Arrays.sort(array);
		for (int i = 0; i < length; i++) {
			if (array.length - 1 - i < 0) {
				if (i == 0) {
					types[i] = 0;
				} else {
					types[i] = 1 - types[i - 1];
				}
			} else {
				types[i] = array[array.length - 1 - i];
			}
		}

		return types;
	}

	/**
	 * 将SportsStatisticsData转为SportsTypeData
	 *
	 * @param sportsStatisticsDatas list
	 * @return map
	 */
	private Map<Integer, SportsTypeData> statisticsTypeData(List<SportsStatisticsData> sportsStatisticsDatas) {
		Map<Integer, SportsTypeData> map = new HashMap<Integer, SportsTypeData>();
		for (SportsStatisticsData sportsStatisticsData : sportsStatisticsDatas) {
			int type = sportsStatisticsData.getType();
			SportsTypeData sportsTypeData = map.get(type);
			if (sportsTypeData == null) {
				sportsTypeData = new SportsTypeData();
				sportsTypeData.setuId(sportsStatisticsData.getuId());
				sportsTypeData.setType(sportsStatisticsData.getType());
				sportsTypeData.setTimes(sportsStatisticsData.getTimes());
				sportsTypeData.setAverUsedTime(sportsStatisticsData.getAverUsedTime());
				sportsTypeData.setAverDistance(sportsStatisticsData.getAverDistance());
				map.put(type, sportsTypeData);
			} else {
				sportsTypeData.setAverDistance((sportsTypeData.getAverDistance() * sportsTypeData.getTimes()
						+ sportsStatisticsData.getAverDistance() * sportsStatisticsData.getTimes())
						/ (sportsTypeData.getTimes() + sportsStatisticsData.getTimes()));
				sportsTypeData.setAverUsedTime((sportsTypeData.getAverUsedTime() * sportsTypeData.getTimes()
						+ sportsStatisticsData.getAverUsedTime() * sportsStatisticsData.getTimes())
						/ (sportsTypeData.getTimes() + sportsStatisticsData.getTimes()));
				sportsTypeData.setTimes(sportsTypeData.getTimes() + sportsStatisticsData.getTimes());
			}
		}

		return map;
	}
}
