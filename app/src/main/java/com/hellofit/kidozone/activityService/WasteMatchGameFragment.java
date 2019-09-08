package com.hellofit.kidozone.activityService;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hellofit.kidozone.R;

/**
 * create an instance of this fragment.
 */
public class WasteMatchGameFragment extends Fragment implements View.OnClickListener {

    private View vWasteMatchGame;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        vWasteMatchGame = inflater.inflate(R.layout.fragment_waste_match_game, container, false);

        Button btn = (Button) vWasteMatchGame.findViewById(R.id.waste_match_game_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return vWasteMatchGame;
    }

    @Override
    public void onClick(View view) {

    }
}
