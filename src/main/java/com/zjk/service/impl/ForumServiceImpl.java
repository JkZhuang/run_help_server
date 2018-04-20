package com.zjk.service.impl;

import com.zjk.dao.ForumDao;
import com.zjk.entity.CommentForumInfo;
import com.zjk.entity.ForumInfo;
import com.zjk.entity.LikeForumInfo;
import com.zjk.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ForumServiceImpl implements ForumService {

	@Autowired
	private ForumDao forumDao;

	public boolean insertForum(ForumInfo forumInfo) {
		return forumDao.insertForum(forumInfo);
	}

	public int selectForumCount(int uId) {
		return forumDao.selectForumCount(uId);
	}

	public boolean insertCommentForum(CommentForumInfo commentForumInfo) {
		return forumDao.insertCommentForum(commentForumInfo);
	}

	public boolean insertLikeForum(LikeForumInfo likeForumInfo) {
		LikeForumInfo info = forumDao.selectLikeForum(likeForumInfo);
		if (info == null) {
			return forumDao.insertLikeForum(likeForumInfo);
		} else {
			return forumDao.deleteLikeForum(likeForumInfo);
		}
	}

	public ArrayList<ForumInfo> query(int uId, int lastFId) {
		ArrayList<ForumInfo> forumInfos = forumDao.query(uId);
		if (forumInfos == null) {
			return null;
		}
		for (ForumInfo info : forumInfos) {
			info.setcFList(forumDao.queryComment(info.getfId()));
			info.setlFList(forumDao.queryLike(info.getfId()));
		}
		return forumInfos;
	}
}
