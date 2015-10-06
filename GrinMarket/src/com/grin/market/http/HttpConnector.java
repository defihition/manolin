package com.grin.market.http;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.grin.market.json.BBSParser;

import android.util.Log;

public class HttpConnector {
	private static final String TAG = HttpConnector.class.getSimpleName();
	

	public void executeThread () {
		Log.d(TAG, "executeThread()");
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<String> response = executor.submit(new HttpRequester());
		long timestamp = System.currentTimeMillis();
		String body = "";
		try {
			body = response.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Log.e(TAG, e.getMessage());
		} catch (ExecutionException e) {
			e.printStackTrace();
			Log.e(TAG, e.getMessage());
			
		}
		Log.d(TAG, body);
		
		BBSParser.parsingBBSJson(body);

		Log.d(TAG, "System Time : " + (System.currentTimeMillis() -timestamp));
	}
	
	public void registerBBS() {
		Log.d(TAG, "registerBBS()");
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> response = executor.submit(new BBSRegister());
		long timestamp = System.currentTimeMillis();
		int responseCode = 404;
		try {
			responseCode = response.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Log.e(TAG, e.getMessage());
		} catch (ExecutionException e) {
			e.printStackTrace();
			Log.e(TAG, e.getMessage());
			
		}
		Log.d(TAG, responseCode + " ");
		Log.d(TAG, "System Time : " + (System.currentTimeMillis() -timestamp));
	}
}