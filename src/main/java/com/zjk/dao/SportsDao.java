package com.zjk.dao;

import com.zjk.entity.*;

import java.util.ArrayList;

public interface SportsDao {

	boolean insert(SportsData sportsData);

	ArrayList<FallThreshold> selectFallThreshold();

	boolean insertGranularity(SportsGranularityData sportsGranularityData);

	int selectMaxSDId();

	ArrayList<SportsData> querySportsData(int uId);

	ArrayList<SportsGranularityData> querySportsGranularityData(int sDId);

	ArrayList<RankingVersion> queryRankingVersion();

	ArrayList<TrainingSuggestData> queryUserSportsSuggestedData(int uId);

	ArrayList<SportsSuggestion> querySportsSuggestion(int uId);

	boolean updateFallThreshold(double fallThreshold);

	TrainingSuggestData queryTrainingSuggestData(int uId);

}
