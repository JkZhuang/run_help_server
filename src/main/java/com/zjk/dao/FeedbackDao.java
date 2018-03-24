package com.zjk.dao;

import com.zjk.entity.Feedback;

import java.util.ArrayList;

public interface FeedbackDao {

	boolean insert(Feedback feedback);

	ArrayList<Feedback> query(int uId);
}
