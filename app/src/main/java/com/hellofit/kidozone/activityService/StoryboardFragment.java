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
public class StoryboardFragment extends Fragment implements View.OnClickListener {

    View vStoryboard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vStoryboard = inflater.inflate(R.layout.fragment_storyboard, container, false);

        return vStoryboard;
    }


    @Override
    public void onClick(View view) {
        
    }
}
