package com.grin.market.http;

import java.util.concurrent.Callable;

import com.grin.market.type.HttpType;

import android.util.Log;

public class BBSRegister implements Callable<Integer> {
	private static final String TAG = BBSRegister.class.getSimpleName();
	
	@Override
	public Integer call() throws Exception {
		Log.d(TAG, "run");
		HttpHelper httpConnect = new HttpHelper();
		return httpConnect.sendPOST(HttpType.GIBU_URL);
	}
}
