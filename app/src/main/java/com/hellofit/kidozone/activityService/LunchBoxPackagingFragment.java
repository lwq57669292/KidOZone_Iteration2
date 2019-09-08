package com.hellofit.kidozone.activityService;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hellofit.kidozone.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LunchBoxPackagingFragment extends Fragment implements View.OnClickListener {

    View vLunchBoxPackaging;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        vLunchBoxPackaging = inflater.inflate(R.layout.fragment_lunch_box_packaging, container, false);

        return vLunchBoxPackaging;
    }

    @Override
    public void onClick(View view) {

    }
}
