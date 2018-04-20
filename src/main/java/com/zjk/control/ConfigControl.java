package com.zjk.control;

import com.zjk.entity.FallThreshold;
import com.zjk.param.GetConfigParam;
import com.zjk.result.GetConfigResult;
import com.zjk.service.ForumService;
import com.zjk.service.SportsService;
import com.zjk.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/config")
public class ConfigControl {

	@Autowired
	private ForumService forumService;

	@Autowired
	private SportsService sportsService;

	@RequestMapping(value = "/getConfig")
	@ResponseBody
	public String getConfig(@RequestBody GetConfigParam param) {
		GetConfigResult result = new GetConfigResult();
		result.dynamicCount = forumService.selectForumCount(param.uId);
		ArrayList<FallThreshold> fallThresholds = sportsService.selectFallThreshold();
		if (fallThresholds != null && fallThresholds.size() > 0) {
			result.fallThreshold = fallThresholds.get(0);
		} else {
			result.fallThreshold = null;
		}
		result.trainingSuggestData = sportsService.queryUserSportsSuggesttedData(param.uId);
		return GsonUtil.toJson(result);
	}
}
