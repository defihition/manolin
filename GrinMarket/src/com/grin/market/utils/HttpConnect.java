package com.grin.market.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class HttpConnect {

	private static final String TAG = HttpConnect.class.getSimpleName();

	// 시간 찾아서 수정..
	private static final int CONNECT_TIMEOUT = 100 * 1000;
	private static final int READ_TIMEOUT = 100 * 1000;

	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String CHAR_SET = "UTF-8";

	HttpURLConnection connection;
	// HTTP GET request
	public void sendGet(String url) {

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
			
			Log.d(TAG, "\nSending 'GET' request to URL : " + url);
			Log.d(TAG, "Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine = "";
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
				Log.d(TAG, inputLine);
			}
			in.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}