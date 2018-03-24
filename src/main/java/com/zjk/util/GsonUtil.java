package com.zjk.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by jason on 16-10-18.
 */
public class GsonUtil {

	public static String toJson(Object obj) {
		GsonBuilder builder = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss");
		Gson gson = builder.create();
		return gson.toJson(obj);
	}

	public static <T> T toObj(String json, Class<T> clazz) {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("yyyy-MM-dd hh:mm:ss");
		Gson gson = builder.create();
		return gson.fromJson(json, clazz);
	}
}
