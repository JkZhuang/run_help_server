package com.zjk.dao;

import com.zjk.entity.*;

import java.util.ArrayList;

public interface SportsDao {

	boolean insert(SportsData sportsData);

	boolean insertGranularity(SportsGranularityData sportsGranularityData);

	int selectMaxSDId();

	ArrayList<SportsData> querySportsData(int uId);

	ArrayList<SportsGranularityData> querySportsGranularityData(int sDId);

	ArrayList<RankingVersion> queryRankingVersion();

	TrainingSuggestData queryUserSportsSuggestedData(int uId);

	ArrayList<SportsSuggestion> querySportsSuggestion(int uId);

	boolean updateFallThreshold(double fallThreshold);

}
