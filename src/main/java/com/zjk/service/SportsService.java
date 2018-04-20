package com.zjk.service;

import com.zjk.entity.*;

import java.util.ArrayList;

public interface SportsService {

	int insert(SportsData sportsData);

	ArrayList<FallThreshold> selectFallThreshold();

	ArrayList<SportsData> querySportsData(int uId);

	ArrayList<RankingVersion> queryRankingVersion();

	TrainingSuggestData queryUserSportsSuggesttedData(int uId);

	ArrayList<SportsSuggestion> querySportsSuggestion(int uId);

	boolean updateFallThreshold(double fallThreshold);

	TrainingSuggestData queryTrainingSuggestData(int uId);
}
