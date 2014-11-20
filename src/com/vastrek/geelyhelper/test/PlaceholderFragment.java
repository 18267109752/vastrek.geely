package com.vastrek.geelyhelper.test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.vastrek.geelyhelper.R;
import com.vastrek.geelyhelper.frame.BaseActivity;
import com.vastrek.geelyhelper.middleware.M;

public class PlaceholderFragment extends Fragment implements
		OnQueryTextListener {

	@ViewInject(R.id.search_view)
	TextView searchView;

	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		ViewUtils.inject(this,rootView);
		searchView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				M.gotoActivity(getActivity(), BaseActivity.class);
			}
		});
		// searchView.setOnQueryTextListener(this);
		return rootView;
	}

	@Override
	public boolean onQueryTextChange(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}