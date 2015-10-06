package com.grin.market.http;

import java.util.concurrent.Callable;

import com.grin.market.type.HttpType;

import android.util.Log;

public class HttpRequester implements Callable<String> {
	private static final String TAG = HttpRequester.class.getSimpleName();
	
	@Override
	public String call() throws Exception {
		Log.d(TAG, "run");
		HttpHelper httpConnect = new HttpHelper();
		return httpConnect.sendGet(HttpType.GIBU_URL);
	}
}
