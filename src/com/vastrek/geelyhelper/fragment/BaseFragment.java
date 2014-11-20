package com.vastrek.geelyhelper.fragment;


import android.app.Activity;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment{

	private Activity mActivity;
    @Override
    public void onAttach(Activity activity) {
        mActivity = activity;
        super.onAttach(activity);
    }
    
    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }
}
