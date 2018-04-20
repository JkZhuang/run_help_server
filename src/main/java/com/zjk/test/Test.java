package com.zjk.test;

import com.zjk.entity.SportsData;
import com.zjk.entity.SportsGranularityData;
import com.zjk.entity.UserInfo;
import com.zjk.param.GetConfigParam;
import com.zjk.param.LoginParam;
import com.zjk.param.RegisteredParam;
import com.zjk.param.UploadSportsDataParam;
import com.zjk.util.DateUtil;
import com.zjk.util.GsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

	public static org.apache.http.client.HttpClient httpclient = HttpClients.createDefault();
//    public static String url = "http://192.168.43.4:8080/user/register";
//	public static String url = "http://172.27.36.1:8080/user/login";
	public static String url = "http://172.27.36.1:8080/config/getConfig";

	public static void main(String[] args) {

		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Content-Type", "application/json");

//		RegisteredParam param = new RegisteredParam();
//		UserInfo userInfo = new UserInfo("18813295240", "123456", "攀登者",
//				"https://f12.baidu.com/it/u=2465775762,1509670197&fm=72", 170,
//				60, DateUtil.stringToDate(DateUtil.dateToString(new Date())), 0, "18813295244");
//		param.userInfo = userInfo;

//		LoginParam param = new LoginParam();
//		UserInfo userInfo = new UserInfo();
//		userInfo.setPhone("18813295240");
//		userInfo.setPassword("123456");
//		param.userInfo = userInfo;

//		UploadSportsDataParam param = new UploadSportsDataParam();
//		SportsData sportsData = new SportsData();
//		sportsData.setuId(2);
//		sportsData.setType(1);
//		sportsData.setUsedTime(30);
//		sportsData.setStartTime(DateUtil.stringToDate(DateUtil.dateToString(new Date())));
//		sportsData.setEndTime(DateUtil.stringToDate(DateUtil.dateToString(new Date())));
//		sportsData.setDistance(4);
//		sportsData.setMaxSpeed(8);
//
//		ArrayList<SportsGranularityData> list = new ArrayList<SportsGranularityData>();
//		SportsGranularityData data1 = new SportsGranularityData();
//		data1.setType(1);
//		data1.setSpeed(6);
//		data1.setLatitude(2.02);
//		data1.setLongitude(5.156);
//		SportsGranularityData data2 = new SportsGranularityData();
//		data2.setType(1);
//		data2.setSpeed(3);
//		data2.setLatitude(4.052);
//		data2.setLongitude(52.1056);
//		list.add(data1);
//		list.add(data2);
//
//		sportsData.setrGDList(list);
//		param.sportsData = sportsData;

		GetConfigParam param = new GetConfigParam();
		param.uId = 6;

		StringEntity se;
		try {
			System.out.println("json->" + GsonUtil.toJson(param));
			se = new StringEntity(GsonUtil.toJson(param), "UTF-8");
			httpPost.setEntity(se);
			HttpResponse response = httpclient.execute(httpPost);
			HttpEntity he = response.getEntity();
			String charset = EntityUtils.getContentCharSet(he);
			String line;
			StringBuilder sb = new StringBuilder();
			BufferedReader rd = new BufferedReader(new InputStreamReader(he.getContent(), charset));
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			System.out.println("response->" + sb);
			httpPost.abort();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
