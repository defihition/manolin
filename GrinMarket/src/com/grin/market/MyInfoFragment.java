package com.grin.market;

import com.grin.market.DealFragment.OnFragmentInteractionListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

public class MyInfoFragment extends Fragment {

	private static final String TAG = MyInfoFragment.class.getSimpleName();

	private static final String USER_ID = "writer";

	// TODO: Rename and change types of parameters
	private static String writer;

	private OnFragmentInteractionListener mListener;

	/**
	 * The Adapter which will be used to populate the ListView/GridView with
	 * Views.
	 */
	static MyInfoFragment fragment = null;

	// TODO: Rename and change types of parameters
	public static MyInfoFragment newInstance(String writerParam) {
		Log.d(TAG, "newInstance()");
		if (fragment != null)
			return fragment;

		fragment = new MyInfoFragment();
		Bundle args = new Bundle();
		args.putString(USER_ID, writer);
		fragment.setArguments(args);
		return fragment;
	}
	
}
