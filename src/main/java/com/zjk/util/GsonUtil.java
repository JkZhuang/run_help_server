package com.zjk.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by jason on 16-10-18.
 */
public class GsonUtil {

	public static final String DATE_PATTEN = "yyyy-MM-dd HH:mm:ss";

	public static String toJson(Object obj) {
		GsonBuilder builder = new GsonBuilder().setDateFormat(DATE_PATTEN);
		Gson gson = builder.create();
		return gson.toJson(obj);
	}

	public static <T> T toObj(String json, Class<T> clazz) {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat(DATE_PATTEN);
		Gson gson = builder.create();
		return gson.fromJson(json, clazz);
	}
}
