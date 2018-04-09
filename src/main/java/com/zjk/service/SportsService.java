package com.zjk.service;

import com.zjk.entity.RankingVersion;
import com.zjk.entity.SportsData;
import com.zjk.entity.SportsSuggestion;
import com.zjk.entity.TrainingSuggestData;

import java.util.ArrayList;

public interface SportsService {

	boolean insert(SportsData sportsData);

	ArrayList<SportsData> querySportsData(int uId);

	ArrayList<RankingVersion> queryRankingVersion();

	TrainingSuggestData queryUserSportsSuggesttedData(int uId);

	ArrayList<SportsSuggestion> querySportsSuggestion(int uId);

	boolean updateFallThreshold(double fallThreshold);
}
