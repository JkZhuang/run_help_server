package com.zjk.service.impl;

import com.zjk.common.DefForumData;
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
import java.util.Collections;

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumDao forumDao;

    @Autowired
    private UserDao userDao;

    private boolean isLastPage = false;

    public boolean isLastPage() {
        return isLastPage;
    }

    public boolean insertForum(ForumInfo forumInfo) {
        return userDao.queryByUId(forumInfo.getuId()) != null && forumDao.insertForum(forumInfo);
    }

    public int selectForumCount(int uId) {
        return forumDao.selectForumCount(uId);
    }

    public boolean insertCommentForum(CommentForumInfo commentForumInfo) {
        return forumDao.selectForumByFId(commentForumInfo.getfId()) != null
                && userDao.queryByUId(commentForumInfo.getuId()) != null
                && userDao.queryByUId(commentForumInfo.gettUId()) != null
                && forumDao.insertCommentForum(commentForumInfo);
    }

    public boolean insertLikeForum(LikeForumInfo likeForumInfo) {
        LikeForumInfo info = forumDao.selectLikeForum(likeForumInfo);
        if (info == null) {
            return userDao.queryByUId(likeForumInfo.getuId()) != null
                    && forumDao.selectForumByFId(likeForumInfo.getfId()) != null
                    && forumDao.insertLikeForum(likeForumInfo);
        }
        return forumDao.deleteLikeForum(likeForumInfo);
    }

    public ArrayList<ForumInfo> query(int uId, int lastFId) {
        ArrayList<ForumInfo> infos = forumDao.query(uId);
        if (infos == null) {
            return null;
        }
        ArrayList<ForumInfo> forumInfos = getResultForum(infos, lastFId);
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
                    commentForumInfo.settUserName(userTarget.getUserName());
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

    private ArrayList<ForumInfo> getResultForum(ArrayList<ForumInfo> infos, int lastFId) {
        ArrayList<ForumInfo> forumInfos = new ArrayList<ForumInfo>();
        Collections.reverse(infos);
        if (lastFId == 0) {
            int endIndex = DefForumData.FETCH_COUNT < infos.size() ? DefForumData.FETCH_COUNT : infos.size();
            for (int i = 0; i < endIndex; i++) {
                forumInfos.add(infos.get(i));
            }
            isLastPage = endIndex == infos.size();
        } else {
            int index = indexOfForumList(infos, lastFId);
            int endIndex = (index + DefForumData.FETCH_COUNT + 1) < infos.size() ? (index + DefForumData.FETCH_COUNT + 1) : infos.size();
            for (int i = index + 1; i < endIndex; i++) {
                forumInfos.add(infos.get(i));
            }
            isLastPage = endIndex == infos.size();
        }
        return forumInfos;
    }

    private int indexOfForumList(ArrayList<ForumInfo> infos, int lastFIf) {
        for (int i = 0; i < infos.size(); i++) {
            if (lastFIf == infos.get(i).getfId()) {
                return i;
            }
        }
        return -1;
    }
}
