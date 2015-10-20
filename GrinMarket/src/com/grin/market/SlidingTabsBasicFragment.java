/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.grin.market;

import java.util.ArrayList;

import com.grin.market.adapter.BBSEntityAdapter;
import com.grin.market.dummy.DummyBBSContent;
import com.grin.market.type.BBSEntity;
import com.grin.market.view.SlidingTabLayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * A basic sample which shows how to use {@link com.grin.market.view.SlidingTabLayout}
 * to display a custom {@link ViewPager} title strip which gives continuous feedback to the user
 * when scrolling.
 */
public class SlidingTabsBasicFragment extends Fragment {

	private static final String TAG = SlidingTabsBasicFragment.class.getSimpleName();

    /**
     * A custom {@link ViewPager} title strip which looks much like Tabs present in Android v4.0 and
     * above, but is designed to give continuous feedback to the user when scrolling.
     */
    private SlidingTabLayout mSlidingTabLayout;

    /**
     * A {@link ViewPager} which will be used in conjunction with the {@link SlidingTabLayout} above.
     */
    private ViewPager mViewPager;
    
    private String[] titles = null;

    /**
     * Inflates the {@link View} which will be displayed by this {@link Fragment}, from the app's resources.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	Log.d(TAG, "onCreateView()");
    	titles = getResources().getStringArray(R.array.tab_title);
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    // BEGIN_INCLUDE (fragment_onviewcreated)
    /**
     * This is called after the {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)} has finished.
     * Here we can pick out the {@link View}s we need to configure from the content view.
     *
     * We set the {@link ViewPager}'s adapter to be an instance of {@link BoardPagerAdapter}. The
     * {@link SlidingTabLayout} is then given the {@link ViewPager} so that it can populate itself.
     *
     * @param view View created in {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    	Log.d(TAG, "onViewCreated()");
        // BEGIN_INCLUDE (setup_viewpager)
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
//        mViewPager.setAdapter(new BoardPagerAdapter(getFragmentManager()));
        mViewPager.setAdapter(new BoardPagerAdapter());
        
        // END_INCLUDE (setup_viewpager)

        // BEGIN_INCLUDE (setup_slidingtablayout)
        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        
        mSlidingTabLayout.setViewPager(mViewPager);
        // END_INCLUDE (setup_slidingtablayout)
    }
    // END_INCLUDE (fragment_onviewcreated)


    // TODO : fregment setting // get title, and 
    class BoardPagerAdapter extends PagerAdapter {
    	
    	public BoardPagerAdapter () {
    		Log.d(TAG, "BoardPagerAdapter - BoardPagerAdapter()");
    	}
    	
        /**
         * @return the number of pages to display
         */
        @Override
        public int getCount() {
//        	Log.d(TAG, "getCount()");
        	if (titles != null)
        		return titles.length;
        	return 3;
        }
        
        // BEGIN_INCLUDE (pageradapter_getpagetitle)
        /**
         * Return the title of the item at {@code position}. This is important as what this method
         * returns is what is displayed in the {@link SlidingTabLayout}.
         * Here we construct one using the position value, but for real application the title should
         * refer to the item's contents.
         */
        @Override
        public CharSequence getPageTitle(int position) {
        	Log.d(TAG, "BoardPagerAdapter - getPageTitle()" + position);
        	if (titles != null)
        		return titles[position];
        	
            return "Item " + (position + 1);
        	
        }
        // END_INCLUDE (pageradapter_getpagetitle)

        /**
         * @return true if the value returned from {@link #instantiateItem(ViewGroup, int)} is the
         * same object as the {@link View} added to the {@link ViewPager}.
         */
        @Override
        public boolean isViewFromObject(View view, Object o) {
        	Log.d(TAG, "BoardPagerAdapter - isViewFromObject()");
            return o == view;
        }

        /**
         * Instantiate the {@link View} which should be displayed at {@code position}. Here we
         * inflate a layout from the apps resources and then change the text view to signify the position.
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
        	Log.d(TAG, "BoardPagerAdapter - instantiateItem() : " + position);
            // Inflate a new layout from our resources
			View view;
			switch (position) {
			case 1:
				view = getActivity().getLayoutInflater().inflate(R.layout.pager_item, container, false);
				break;
			case 2:
				view =  getActivity().getLayoutInflater().inflate(R.layout.fragment_deal, container, false);

				// // Set the adapter
				BBSEntityAdapter bbsAdapter = new BBSEntityAdapter(getActivity(), android.R.layout.simple_list_item_1,
						(ArrayList<BBSEntity>) DummyBBSContent.ITEMS);
				AbsListView mListView = (AbsListView) view.findViewById(android.R.id.list);
				((AdapterView<ListAdapter>) mListView).setAdapter(bbsAdapter);

				// Set OnItemClickListener so we can be notified on item clicks

				break;
			default:
				view = getActivity().getLayoutInflater().inflate(R.layout.fragment_deal, container, false);

        	}
//            View view = getActivity().getLayoutInflater().inflate(R.layout.pager_item, container, false);
            // Add the newly created View to the ViewPager
            container.addView(view);
//
//            
//            ((FragmentManager)getSupportFragmentManager()).beginTransaction().replace(R.id.sample_content_fragment, fragment).commit();

            // Retrieve a TextView from the inflated View, and update it's text
//            TextView title = (TextView) view.findViewById(R.id.item_title);
//            title.setText(String.valueOf(position + 1));

            return view;
        }

        /**
         * Destroy the item from the {@link ViewPager}. In our case this is simply removing the
         * {@link View}.
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            Log.i(TAG, "BoardPagerAdapter - destroyItem() [position: " + position + "]");
        }
    }
}