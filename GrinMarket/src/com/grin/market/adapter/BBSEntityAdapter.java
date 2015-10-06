package com.grin.market.adapter;

import java.util.ArrayList;

import com.grin.market.R;
import com.grin.market.type.BBSEntity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class BBSEntityAdapter extends ArrayAdapter<BBSEntity> {

	private static final String TAG = BBSEntityAdapter.class.getSimpleName();

	private ArrayList<BBSEntity> items;
	private Context context;
	
	// for debugging
	private String[] titles = {"Deal", "Rounge", "Donation"};
	
	public BBSEntityAdapter(Context context, int resource, ArrayList<BBSEntity> bbsList) {
		super(context, resource, bbsList);
		this.context = context;
		items = bbsList;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.d(TAG, "getView() : " + titles[position] );
		View v = convertView;
		final int pos = position;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.list_layout, null);
		}

		/*v.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO :  화면 전환 body와 다른 것으로 표시되는 화면이 보여져야함.. 이건 어쩐다 ㅋㅋㅋㅋ
				Toast.makeText(context, items.get(pos).getTitle(), Toast.LENGTH_SHORT).show();
			}
		});*/
		
		BBSEntity p = items.get(position);
		if (p != null) {
			TextView tt = (TextView) v.findViewById(R.id.titleText);
			TextView bt = (TextView) v.findViewById(R.id.writerText);
			if (tt != null) {
				tt.setText(p.getTitle());
			}
			if (bt != null) {
				bt.setText("글쓴이: " + p.getWriter());
			}
		}
		return v;
	}
}