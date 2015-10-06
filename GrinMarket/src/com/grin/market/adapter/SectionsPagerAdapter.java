package com.grin.market.adapter;

import java.util.ArrayList;
import java.util.List;

import com.grin.market.DealFragment;
import com.grin.market.MainActivity.PlaceholderFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

	private static final String TAG = SectionsPagerAdapter.class.getSimpleName();

	private final List<Fragment> fragments = new ArrayList<Fragment>();
	
	public SectionsPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
		fragments.add(DealFragment.newInstance("aa"));
		fragments.add(DealFragment.newInstance("aa"));
		fragments.add(DealFragment.newInstance("aa"));
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		return PlaceholderFragment.newInstance(position+1);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		//TODO : fix get title
		return "aaaa";
	}
}