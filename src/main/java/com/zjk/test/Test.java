package com.zjk.test;

import com.zjk.entity.UserInfo;
import com.zjk.param.RegisteredParam;
import com.zjk.util.GsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

	public static String url = "http://localhost:8080/shujuku/merchant/register";
	public static org.apache.http.client.HttpClient httpclient = HttpClients.createDefault();
	public static String url1 = "http://172.27.36.18:8080/user/register";

	public static void main(String[] args) {

		HttpPost httpPost = new HttpPost(url1);
		httpPost.setHeader("Content-Type", "application/json");

		RegisteredParam param = new RegisteredParam();
		UserInfo userInfo = new UserInfo("18813295244", "123456", "攀登者",
				"https://f12.baidu.com/it/u=2465775762,1509670197&fm=72", 170,
				60, 24, 0, "18813295244");
		param.userInfo = userInfo;

		StringEntity se;
		try {
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
			System.out.println(sb);
			httpPost.abort();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
