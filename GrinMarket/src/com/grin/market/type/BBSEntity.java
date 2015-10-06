package com.grin.market.type;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class BBSEntity {
	private String bbsID;
	private String title;
	private String writer;
	private String body;
	private long timestamp;
	private boolean fileFlag;
	private String fileUrl;
	private String category;

	public BBSEntity(String bbsID, String title, String writer, String body) {
		super();
		this.bbsID = bbsID;
		this.title = title;
		this.writer = writer;
		this.body = body;
	}

	public BBSEntity(String title, String writer, String body) {
		this.title = title;
		this.writer = writer;
		this.body = body;
	}
	
	public BBSEntity() {
	}

	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		try {
			json.put(BBSEntityType.BBS_ID, bbsID);
			json.put(BBSEntityType.BBS_TITLE, title);
			json.put(BBSEntityType.BBS_BODY, body);
			json.put(BBSEntityType.WRITER, writer);
//			json.put(BBSEntityType.CATEGORY, category); 나중에 넣음 
			json.put(BBSEntityType.FILE_FLAG, false);
			// timestamp는 server에서 입력될때 넣도록 함
		} catch (JSONException e) {
			e.printStackTrace();
			Log.e("BBSEntity", "json object make err");
		} 
		return json.toString();
//		return "BBSEntity [bbsID=" + bbsID + ", title=" + title + ", writer=" + writer + ", body=" + body
//				+ ", timestamp=" + timestamp + ", fileFlag=" + fileFlag + ", fileUrl=" + fileUrl + ", category="
//				+ category + "]";
	}

	public String getBbsID() {
		return bbsID;
	}

	public void setBbsID(String bbsID) {
		this.bbsID = bbsID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isFileFlag() {
		return fileFlag;
	}

	public void setFileFlag(boolean fileFlag) {
		this.fileFlag = fileFlag;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}