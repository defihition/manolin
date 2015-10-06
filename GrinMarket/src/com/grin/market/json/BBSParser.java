package com.grin.market.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.grin.market.type.BBSEntity;
import com.grin.market.type.BBSEntityType;

import android.util.Log;

public class BBSParser {
	// static¿∏∑Œ «‘.
	static private final String TAG = BBSParser.class.getSimpleName();

	private static BBSEntity fillBBSEntity(JSONObject obj) {
		BBSEntity bbs = new BBSEntity();
		if (obj == null) 
			return null;

		try {
			bbs.setBbsID(obj.getString(BBSEntityType.BBS_ID));
			bbs.setTitle(obj.getString(BBSEntityType.BBS_TITLE));
			bbs.setBody(obj.getString(BBSEntityType.BBS_BODY));
			bbs.setWriter(obj.getString(BBSEntityType.WRITER));
			bbs.setTimestamp(obj.getLong(BBSEntityType.TIMESTAMP));
			bbs.setCategory(obj.getString(BBSEntityType.CATEGORY));

			boolean flag = obj.getBoolean(BBSEntityType.FILE_FLAG);
			bbs.setFileFlag(flag);
			if (flag) {
				bbs.setFileUrl(obj.getString(BBSEntityType.FILE));
			}
		} catch (JSONException e) {
			e.printStackTrace();
			Log.d(TAG, "json parsing exception");
		}
		return bbs;
	}

	public static List<BBSEntity> parsingBBSJson(String jsonStr) {
		Log.d(TAG, "parsingBBSJson() " + jsonStr);
		ArrayList<BBSEntity> result = new ArrayList<BBSEntity>();

		if (jsonStr == null || jsonStr.length() == 0)
			return result;

		try {
			JSONObject jsonObj = new JSONObject(jsonStr);
			JSONArray jarray = jsonObj.getJSONArray(BBSEntityType.JSON_HEADER);

			for (int i = 0; i < jarray.length(); i++) {
				JSONObject object = jarray.getJSONObject(i);
				BBSEntity entry = fillBBSEntity(object);
				if (entry != null) 
					result.add(entry);
				Log.d(TAG, "ddd*"+entry.toString());
			}

		} catch (JSONException e) {
			Log.d(TAG, e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	static List<BBSEntity> parsingBBSJSON(String jsonStr) {
		Log.d(TAG, "parsingBBSJSON() " + jsonStr);

		ArrayList<BBSEntity> result = new ArrayList<BBSEntity>();

		if (jsonStr == null || jsonStr.length() == 0)
			return result;

		try {
			JSONObject firstObj = new JSONObject(jsonStr);
			firstObj.getJSONObject(BBSEntityType.JSON_HEADER);

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