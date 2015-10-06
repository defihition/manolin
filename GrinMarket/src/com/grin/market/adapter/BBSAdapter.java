package com.grin.market.adapter;
//import com.grin.market.R;
//import com.grin.market.type.BBSEntity;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//public class BBSAdapter extends BaseAdapter {
//
//	private Context context;
//	private BBSEntity[] bbsList;
//
//	LayoutInflater inflater;
//
//	public BBSAdapter(Context context, BBSEntity[] bbsList) {
//		this.context = context;
//		this.bbsList = bbsList;
//
//		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//	}
//
//	@Override
//	public int getCount() {
//		return bbsList.length;
//	}
//
//	@Override
//	public Object getItem(int position) {
//		if (position >= getCount())
//			position = 0;
//
//		return bbsList[position];
//	}
//
//	@Override
//	public long getItemId(int position) {
//		return position;
//	}
//
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		View bbsRowView = inflater.inflate(R.layout.list_item, null);
//		/*
//		 * ImageView image = (ImageView) bbsRow.findViewById(R.id.ImageView);
//		 * image.setImageBitmap(imageFromUrl(photos[position].makeURL()));
//		 */
//		TextView title = (TextView) bbsRowView.findViewById(R.id.TextView);
//		title.setText("aaaaaaaaaa");
//
//		return bbsRowView;
//	}
//
//}
