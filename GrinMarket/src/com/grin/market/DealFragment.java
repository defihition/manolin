package com.grin.market;

import java.util.ArrayList;

import com.grin.market.adapter.BBSEntityAdapter;
import com.grin.market.dummy.DummyBBSContent;
import com.grin.market.floatingButton.FloatingActionButton;
import com.grin.market.type.BBSEntity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the
 * ListView with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the
 * {@link OnFragmentInteractionListener} interface.
 */
public class DealFragment extends ListFragment implements AbsListView.OnItemClickListener {

	private static final String TAG = DealFragment.class.getSimpleName();
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String USER_ID = "writer";

	// TODO: Rename and change types of parameters
	private static String writer;

	private OnFragmentInteractionListener mListener;

	/**
	 * The fragment's ListView/GridView.
	 */
	private AbsListView mListView;

	/**
	 * The Adapter which will be used to populate the ListView/GridView with
	 * Views.
	 */
	private BBSEntityAdapter bbsAdapter;
	static DealFragment fragment = null;

	// TODO: Rename and change types of parameters
	public static DealFragment newInstance(String writerParam) {
		Log.d(TAG, "newInstance()");
		if (fragment != null)
			return fragment;

		fragment = new DealFragment();
		Bundle args = new Bundle();
		args.putString(USER_ID, writer);
		fragment.setArguments(args);
		return fragment;
	}

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public DealFragment() {
	}

    /* (non-Javadoc)
     * @see android.app.ListFragment#onListItemClick(android.widget.ListView, android.view.View, int, long)
     */	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Log.d(TAG, "onListItemClick()" + id + " " + position);
//		Toast.makeText(context, items.get(pos).getTitle(), Toast.LENGTH_SHORT).show(); /// 
		mListener.onReadDealPost(String.valueOf(position));
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate()");
		super.onCreate(savedInstanceState);

		if (getArguments() != null) {
			writer = getArguments().getString(USER_ID);
		}

		bbsAdapter = new BBSEntityAdapter(getActivity(), android.R.layout.simple_list_item_1,
				(ArrayList<BBSEntity>) DummyBBSContent.ITEMS);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView()");
		View view = inflater.inflate(R.layout.fragment_deal, container, false);

		// // Set the adapter
		mListView = (AbsListView) view.findViewById(android.R.id.list);
		((AdapterView<ListAdapter>) mListView).setAdapter(bbsAdapter);

		// Set OnItemClickListener so we can be notified on item clicks
		mListView.setOnItemClickListener(this);
/*
		FloatingActionButton mFloatingButton = (FloatingActionButton) view.findViewById(R.id.mFloatingActionButton);
		mFloatingButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "click", Toast.LENGTH_LONG).show();;
				
			}
		});
		mFloatingButton.attachToListView(mListView);
*/
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		Log.d(TAG, "onAttach()");
		super.onAttach(activity);
		try {
			mListener = (OnFragmentInteractionListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		Log.d(TAG, "onDetach()");
		super.onDetach();
		mListener = null;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Log.d(TAG, "onItemClick() - listview override"  + id + "  "  + position);
		if (null != mListener) {
			// Notify the active callbacks interface (the activity, if the
			// fragment is attached to one) that an item has been selected.
			mListener.onReadDealPost(DummyBBSContent.ITEMS.get(position).getBbsID());
		}
	}

	/**
	 * The default content for this Fragment has a TextView that is shown when
	 * the list is empty. If you would like to change the text, call this method
	 * to supply the text it should use.
	 */
	public void setEmptyText(CharSequence emptyText) {
		Log.d(TAG, "setEmptyText()");
		View emptyView = mListView.getEmptyView();

		if (emptyView instanceof TextView) {
			((TextView) emptyView).setText(emptyText);
		}
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated to
	 * the activity and potentially other fragments contained in that activity.
	 * <p/>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentInteractionListener {
		public void onReadDealPost(String id);
	}
}