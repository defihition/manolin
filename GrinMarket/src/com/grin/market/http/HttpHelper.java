package com.grin.market.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class HttpHelper {
	private static final String TAG = HttpHelper.class.getSimpleName();

	// 시간 찾아서 수정..
	private static final int CONNECT_TIMEOUT = 100 * 1000;
	private static final int READ_TIMEOUT = 100 * 1000;

	HttpURLConnection connection;
	StringBuffer response = null;

	public String sendGet(String url) {
		response = new StringBuffer();
		URL obj;
		try {
			obj = new URL(url);

			connection = (HttpURLConnection) obj.openConnection();

			connection.setRequestMethod("GET");
			connection.setConnectTimeout(CONNECT_TIMEOUT);
			connection.setReadTimeout(READ_TIMEOUT);
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json");
//			connection.setRequestProperty("User-Agent", USER_AGENT);
//			connection.setRequestProperty("Cache-Control", "no-cache");
			connection.setDoInput(true);

			int responseCode = connection.getResponseCode();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine = "";
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
//				Log.d(TAG, inputLine);
			}
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
			Log.e(TAG, e.getMessage());
		}
		return response.toString();
	}
	
	
	public Integer sendPOST(String url) {
		Log.d(TAG, "sendPOST " + url);
		response = new StringBuffer();
		URL obj;
		int responseCode = 404;
		try {
			obj = new URL(url);
			connection = (HttpURLConnection) obj.openConnection();
			connection.setRequestMethod("POST");// post는 따로 작성 해야함.. 서버쪽에서 
			connection.setConnectTimeout(CONNECT_TIMEOUT);
			connection.setReadTimeout(READ_TIMEOUT);
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json");
			Log.d(TAG, "sendPOST  " + url);
			// connection.setRequestProperty("User-Agent", USER_AGENT);
			// connection.setRequestProperty("Cache-Control", "no-cache");
			connection.setDoInput(true);
			responseCode = connection.getResponseCode();
			Log.d(TAG, "sendPOST " + url);
		} catch (IOException e) {
			e.printStackTrace();
			Log.e(TAG, e.getMessage());
		}

		return responseCode;
	}
}
