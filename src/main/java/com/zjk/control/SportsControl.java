package com.zjk.control;

import com.zjk.param.*;
import com.zjk.result.*;
import com.zjk.service.SportsService;
import com.zjk.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sports")
public class SportsControl {

	@Autowired
	private SportsService sportsService;

	@RequestMapping(value = "/uploadSportsData")
	@ResponseBody
	public String uploadSportsData(@RequestBody UploadSportsDataParam param) {
		UploadSportsDataResult result = new UploadSportsDataResult();
		boolean status = sportsService.insert(param.sportsData);
		if (status) {
			result.bool = true;
			result.status = 1;
		} else {
			result.bool = false;
			result.status = 0;
			result.errMsg = "上传数据失败，请稍后重试";
		}
		return GsonUtil.toJson(result);
	}

	@RequestMapping(value = "/getUserSportsData")
	@ResponseBody
	public String getUserSportsData(@RequestBody GetUserSportsDataParam param) {
		GetUserSportsDataResult result = new GetUserSportsDataResult();
		result.sportsDatas = sportsService.querySportsData(param.uId);
		return GsonUtil.toJson(result);
	}

	@RequestMapping(value = "/getRankingVersion")
	@ResponseBody
	public String getRankingVersion(@RequestBody GetRankingVersionParam param) {
		GetRankingVersionResult result = new GetRankingVersionResult();
		result.rankingVersions = sportsService.queryRankingVersion();
		return GsonUtil.toJson(result);
	}

	@RequestMapping(value = "/getUserSportsSuggestedData")
	@ResponseBody
	public String getUserSportsSuggestedData(@RequestBody GetUserSportsSuggestedDataParam param) {
		GetUserSportsSuggestedDataResult result = new GetUserSportsSuggestedDataResult();
		result.trainingSuggestData = sportsService.queryUserSportsSuggesttedData(param.uId);
		return GsonUtil.toJson(result);
	}

	@RequestMapping(value = "/getSportsSuggestion")
	@ResponseBody
	public String getSportsSuggestion(@RequestBody GetSportsSuggestionParam param) {
		GetSportsSuggestionResult result = new GetSportsSuggestionResult();
		result.sportsSuggestion = sportsService.querySportsSuggestion(param.uId);
		return GsonUtil.toJson(result);
	}

	@RequestMapping(value = "/updateFallThreshold")
	@ResponseBody
	public String updateFallThreshold(@RequestBody UpdateFallThresholdParam param) {
		UpdateFallThresholdResult result = new UpdateFallThresholdResult();
		boolean status = sportsService.updateFallThreshold(param.fallThreshold);
		if (status) {
			result.bool = true;
			result.status = 1;
		} else {
			result.bool = false;
			result.status = 0;
			result.errMsg = "更新摔倒阈值失败，请稍后重试";
		}
		return GsonUtil.toJson(result);
	}

}
