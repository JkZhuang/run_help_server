package com.zjk.service.impl;

import com.zjk.dao.SportsDao;
import com.zjk.entity.RankingVersion;
import com.zjk.entity.SportsData;
import com.zjk.entity.SportsSuggestion;
import com.zjk.entity.TrainingSuggestData;
import com.zjk.service.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SportsServiceImpl implements SportsService {

	@Autowired
	private SportsDao sportsDao;

	public boolean insert(SportsData sportsData) {
		return sportsDao.insert(sportsData);
	}

	public ArrayList<SportsData> querySportsData(int uId) {
		ArrayList<SportsData> sportsDatas = sportsDao.querySportsData(uId);
		if (sportsDatas == null) {
			return null;
		}
		for (SportsData data : sportsDatas) {
			data.setrGDList(sportsDao.querySportsGranularityData(data.getsDId()));
		}
		return sportsDatas;
	}

	public ArrayList<RankingVersion> queryRankingVersion() {
		return sportsDao.queryRankingVersion();
	}

	public TrainingSuggestData queryUserSportsSuggesttedData(int uId) {
		return sportsDao.queryUserSportsSuggestedData(uId);
	}

	public SportsSuggestion querySportsSuggestion(int uId) {
		return sportsDao.querySportsSuggestion(uId);
	}

	public boolean updateFallThreshold(double fallThreshold) {
		return sportsDao.updateFallThreshold(fallThreshold);
	}
}
