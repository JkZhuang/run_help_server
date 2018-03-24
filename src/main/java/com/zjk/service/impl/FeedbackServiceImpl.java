package com.zjk.service.impl;

import com.zjk.dao.FeedbackDao;
import com.zjk.entity.Feedback;
import com.zjk.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;

	public boolean insert(Feedback feedback) {
		return feedbackDao.insert(feedback);
	}

	public ArrayList<Feedback> query(int uId) {
		return feedbackDao.query(uId);
	}
}
