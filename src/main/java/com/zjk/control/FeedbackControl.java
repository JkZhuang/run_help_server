package com.zjk.control;

import com.zjk.param.GetFeedbackParam;
import com.zjk.param.SetFeedbackParam;
import com.zjk.result.GetFeedbackResult;
import com.zjk.result.SetFeedbackResult;
import com.zjk.service.FeedbackService;
import com.zjk.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/feedback")
public class FeedbackControl {

	@Autowired
	private FeedbackService feedbackService;

	@RequestMapping(value = "/setFeedback")
	@ResponseBody
	public String setFeedback(@RequestBody SetFeedbackParam param) {
		SetFeedbackResult result = new SetFeedbackResult();
		boolean status = feedbackService.insert(param.feedback);
		if (status) {
			result.bool = true;
			result.status = 1;
		} else {
			result.bool = false;
			result.status = 0;
			result.errMsg = "发送意见反馈失败，请稍后重试";
		}
		return GsonUtil.toJson(result);
	}

	@RequestMapping(value = "/getFeedback")
	public String getFeedback(@RequestBody GetFeedbackParam param) {
		GetFeedbackResult result = new GetFeedbackResult();
		result.feedbacks = feedbackService.query(param.uId);
		return GsonUtil.toJson(result);
	}

}
