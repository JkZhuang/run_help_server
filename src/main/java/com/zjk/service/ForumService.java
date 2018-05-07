package com.zjk.service;

import com.zjk.entity.CommentForumInfo;
import com.zjk.entity.ForumInfo;
import com.zjk.entity.LikeForumInfo;

import java.util.ArrayList;

public interface ForumService {

	boolean isLastPage();

	boolean insertForum(ForumInfo forumInfo);

	int selectForumCount(int uId);

	boolean insertCommentForum(CommentForumInfo commentForumInfo);

	boolean insertLikeForum(LikeForumInfo likeForumInfo);

	ArrayList<ForumInfo> query(int uId, int lastFId);
}
