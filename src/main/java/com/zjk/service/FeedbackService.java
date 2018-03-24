package com.zjk.service;

import com.zjk.entity.Feedback;

import java.util.ArrayList;

public interface FeedbackService {

	boolean insert(Feedback feedback);

	ArrayList<Feedback> query(int uId);
}
