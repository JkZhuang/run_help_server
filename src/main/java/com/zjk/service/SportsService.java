package com.zjk.service;

import com.zjk.entity.*;

import java.util.ArrayList;

public interface SportsService {

	int insert(SportsData sportsData);

	ArrayList<FallThreshold> selectFallThreshold();

	ArrayList<SportsData> querySportsData(int uId);

	ArrayList<RankingVersion> queryRankingVersion();

	ArrayList<TrainingSuggestData> queryUserSportsSuggesttedData(int uId);

	ArrayList<SportsSuggestion> querySportsSuggestion(int uId);

	boolean updateFallThreshold(double fallThreshold);

	TrainingSuggestData queryTrainingSuggestData(int uId);

	ArrayList<SportsStatisticsData> querySportsStatisticsDataByUId(int uId);

	boolean insertSportsSuggestion(SportsSuggestion sportsSuggestion);

	boolean delSportsSuggestion(int sSId);
}
