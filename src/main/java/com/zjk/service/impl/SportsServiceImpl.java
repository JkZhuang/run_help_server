package com.zjk.service.impl;

import com.zjk.dao.SportsDao;
import com.zjk.entity.*;
import com.zjk.service.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SportsServiceImpl implements SportsService {

	@Autowired
	private SportsDao sportsDao;

	public int insert(SportsData sportsData) {
		if (sportsData.getrGDList() == null || sportsData.getrGDList().size() == 0) {
			return 2;
		}
		boolean bool = sportsDao.insert(sportsData);
		if (!bool) {
			return 0;
		}
		int sDId = sportsDao.selectMaxSDId();
		for (SportsGranularityData sportsGranularityData : sportsData.getrGDList()) {
			sportsGranularityData.setsDId(sDId);
			bool = sportsDao.insertGranularity(sportsGranularityData);
			if (!bool) {
				return 0;
			}
		}
		return bool ? 1 : 0;
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

	public ArrayList<SportsSuggestion> querySportsSuggestion(int uId) {
		return sportsDao.querySportsSuggestion(uId);
	}

	public boolean updateFallThreshold(double fallThreshold) {
		return sportsDao.updateFallThreshold(fallThreshold);
	}
}
