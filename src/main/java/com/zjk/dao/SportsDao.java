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

	boolean insertRV(RankingVersion rankingVersion);

	RankingVersion queryRVByUId(int uId);

	boolean updateRV(RankingVersion rankingVersion);

	ArrayList<TrainingSuggestData> queryUserSportsSuggestedData(int uId);

	boolean insertSuggestedData(TrainingSuggestData trainingSuggestData);

	TrainingSuggestData querySuggestedData(TrainingSuggestData trainingSuggestData);

	boolean updateSuggestedData(TrainingSuggestData trainingSuggestData);

	ArrayList<SportsSuggestion> querySportsSuggestion(int uId);

	boolean updateFallThreshold(double fallThreshold);

	TrainingSuggestData queryTrainingSuggestData(int uId);

	SportsData querySportsDataBySDId(int sDId);

}
