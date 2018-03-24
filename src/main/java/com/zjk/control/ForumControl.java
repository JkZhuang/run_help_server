package com.zjk.control;

import com.zjk.param.CommentForumParam;
import com.zjk.param.GetForumParam;
import com.zjk.param.LikeForumParam;
import com.zjk.param.PublishForumParam;
import com.zjk.result.CommentForumResult;
import com.zjk.result.GetForumResult;
import com.zjk.result.LikeForumResult;
import com.zjk.result.PublishForumResult;
import com.zjk.service.ForumService;
import com.zjk.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/forum")
public class ForumControl {

	@Autowired
	private ForumService forumService;

	@RequestMapping(value = "/publishForum")
	@ResponseBody
	public String publishForum(@RequestBody PublishForumParam param) {
		PublishForumResult result = new PublishForumResult();
		boolean status = forumService.insertForum(param.forumInfo);
		if (status) {
			result.bool = true;
			result.status = 1;
		} else {
			result.bool = false;
			result.status = 0;
			result.errMsg = "publishForum fail";
		}
		return GsonUtil.toJson(result);
	}

	@RequestMapping(value = "/commentForum")
	@ResponseBody
	public String commentForum(@RequestBody CommentForumParam param) {
		CommentForumResult result = new CommentForumResult();
		boolean status = forumService.insertCommentForum(param.commentForumInfo);
		if (status) {
			result.bool = true;
			result.status = 1;
		} else {
			result.bool = false;
			result.status = 0;
			result.errMsg = "commentForum fail";
		}
		return GsonUtil.toJson(result);
	}

	@RequestMapping(value = "/likeForum")
	@ResponseBody
	public String likeForum(@RequestBody LikeForumParam param) {
		LikeForumResult result = new LikeForumResult();
		boolean status = forumService.insertLikeForum(param.likeForumInfo);
		if (status) {
			result.bool = true;
			result.status = 1;
		} else {
			result.bool = false;
			result.status = 0;
			result.errMsg = "likeForum fail";
		}
		return GsonUtil.toJson(result);
	}

	@RequestMapping(value = "/getForum")
	@ResponseBody
	public String getForum(@RequestBody GetForumParam param) {
		GetForumResult result = new GetForumResult();
		result.forumInfos = forumService.query(param.uId, param.lastFId);
		return GsonUtil.toJson(result);
	}
}
