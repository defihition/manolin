package com.grin.market.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.grin.market.type.BBSEntity;
import com.grin.market.type.BBSEntityType;

import android.util.Log;

public class JSONParser {
	// static¿∏∑Œ «‘.
	static private final String TAG = JSONParser.class.getSimpleName();

	static List<BBSEntity> parsingBBSJSON(String jsonStr) {
		Log.d(TAG, "parsingBBSJSON() " + jsonStr);

		ArrayList<BBSEntity> result = new ArrayList<BBSEntity>();

		if (jsonStr == null || jsonStr.length() == 0)
			return result;

		try {
			JSONObject firstObj = new JSONObject(jsonStr);
			// JSONObject firstData =
			// firstObj.getJSONObject(BBSEntityType.JSON_HEADER);
			JSONArray bbsList = firstObj.getJSONArray(BBSEntityType.JSON_HEADER);
			for (int i = 0; i < bbsList.length(); i++) {
				JSONObject tmpJSON = bbsList.getJSONObject(i);
				BBSEntity entity = new BBSEntity(tmpJSON.getString(BBSEntityType.BBS_TITLE),
						tmpJSON.getString(BBSEntityType.USER_ID), tmpJSON.getString(BBSEntityType.BBS_BODY));
				result.add(entity);
			}
		} catch (JSONException e) {
			Log.d(TAG, "JSON Parsing Error : " + e.getMessage());
		}

		return result;
	}
}
