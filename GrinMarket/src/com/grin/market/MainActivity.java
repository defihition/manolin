package com.grin.market;

import com.grin.market.adapter.SectionsPagerAdapter;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks, DealFragment.OnFragmentInteractionListener, DetailFragment.OnFragmentInteractionListener{
	
	private static String TAG = MainActivity.class.getSimpleName();

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;
	private String userID;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.navigation_drawer);
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
		
		mTitle = getTitle();

		//TODO : list fragment replace and commit
        if (savedInstanceState == null) {
        	Log.d(TAG, "savedInstance stat is null");
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            SlidingTabsBasicFragment fragment = new SlidingTabsBasicFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
        // get listview
//		HttpConnector connector = new HttpConnector();
//		connector.executeThread();
		
//		HttpConnector registerBBS = new HttpConnector();
//		registerBBS.registerBBS();
		// Set up the drawer.
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		Log.d(TAG, "onNavigationDrawerItemSelected() : " + position);
		Fragment fragment = MyInfoFragment.newInstance(userID);
	    FragmentManager fragmentManager = getSupportFragmentManager(); // For AppCompat use getSupportFragmentManager
	    switch(position) {
	        case 1:
	            fragment = MyInfoFragment.newInstance(userID);
	            break;
//	        case 1:
//	            fragment = DealFragment.newInstance(userID);
//	            break;
	        default:
	        	mNavigationDrawerFragment.mDrawerToggle.onDrawerClosed(null);
	        	return;
	    }
	    fragmentManager.beginTransaction().replace(R.id.sample_content_fragment, fragment).commit();
	}
/*
	public void onSectionAttached(int number) {
		Log.d(TAG, "onSectionAttached");
		String[] titles = getResources().getStringArray(R.array.tab_title);
		mTitle = titles[number-1];
	}*/

	public void restoreActionBar() {
		Log.d(TAG, "restoreActionBar()");
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.d(TAG, "onCreateOptionsMenu()");
		if (mNavigationDrawerFragment != null && !mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.d(TAG, "onOptionsItemSelected");
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 *//*
	public static class PlaceholderFragment extends Fragment {
		*//**
		 * The fragment argument representing the section number for this
		 * fragment.
		 *//*

		private static final String ARG_SECTION_NUMBER = "section_number";

		*//**
		 * Returns a new instance of this fragment for the given section number.
		 *//*
		public static PlaceholderFragment newInstance(int sectionNumber) {
			Log.d(TAG, "newInstance section number" + sectionNumber);

			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			Log.d(TAG, "onCreateView");
			View rootView = inflater.inflate(R.layout.fragment_deal, container, false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			Log.d(TAG, "onAttach");
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
		}
	}*/

	@Override
	public void onReadDealPost(String id) {
		Log.d(TAG, "onReadDealPost() : "  + id);
	
		DetailFragment detailfragment = DetailFragment.newInstance("a", "b"); // TODO : fix argument
	    FragmentManager fragmentManager = getSupportFragmentManager(); // For AppCompat use getSupportFragmentManager
	    fragmentManager.beginTransaction().replace(R.id.container, detailfragment).commit();

        /*DetailFragment articleFrag = (DetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_d);

        if (articleFrag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the DetailFragment to update its content
            articleFrag.updateArticleView(position);
        } else {
            // Otherwise, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            DetailFragment newFragment = new DetailFragment();
            Bundle args = new Bundle();
            args.putInt(DetailFragment.ARG_POSITION, position);
            newFragment.setArguments(args);
        
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }*/
	}

	// detailFragment onclick listener
	@Override
	public void onFragmentInteraction(Uri uri) {
		Log.d(TAG, "onFragmentInteraction");
		
	}
}