package com.zjk.service.impl;

import com.zjk.dao.ForumDao;
import com.zjk.dao.UserDao;
import com.zjk.entity.CommentForumInfo;
import com.zjk.entity.ForumInfo;
import com.zjk.entity.LikeForumInfo;
import com.zjk.entity.UserInfo;
import com.zjk.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ForumServiceImpl implements ForumService {

	@Autowired
	private ForumDao forumDao;

	@Autowired
	private UserDao userDao;

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
			UserInfo userInfo = userDao.queryByUId(info.getuId());
			info.setHeadPhotoUrl(userInfo.getHeadUrl());
			info.setUserName(userInfo.getUserName());

			ArrayList<CommentForumInfo> cFList = forumDao.queryComment(info.getfId());
			if (cFList != null) {
				for (CommentForumInfo commentForumInfo : cFList) {
					UserInfo userMain = userDao.queryByUId(commentForumInfo.getuId());
					commentForumInfo.setUserName(userMain.getUserName());

					UserInfo userTarget = userDao.queryByUId(commentForumInfo.gettUId());
					commentForumInfo.setUserName(userTarget.getUserName());
				}
			}
			info.setcFList(cFList);

			ArrayList<LikeForumInfo> lFList = forumDao.queryLike(info.getfId());
			if (lFList != null) {
				for (LikeForumInfo likeForumInfo : lFList) {
					UserInfo userLike = userDao.queryByUId(likeForumInfo.getuId());
					likeForumInfo.setUserName(userLike.getUserName());
				}
			}
			info.setlFList(lFList);
		}
		return forumInfos;
	}
}
