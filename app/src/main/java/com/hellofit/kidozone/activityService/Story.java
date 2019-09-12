package com.hellofit.kidozone.activityService;

import android.os.Bundle;

import com.hellofit.kidozone.R;
import com.hellofit.kidozone.dialog.SuccessDialog;
import com.hellofit.kidozone.puzzleGame.PuzzleGame;
import com.hellofit.kidozone.ui.PuzzleLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Story extends AppCompatActivity implements PuzzleGame.GameStateListener {

    private PuzzleLayout puzzleLayout;
    private PuzzleGame puzzleGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);
        initView();
        initListener();
    }

    private void initView() {
        puzzleLayout = (PuzzleLayout) findViewById(R.id.puzzleLayout);
        puzzleGame = new PuzzleGame(this, puzzleLayout);
    }

    private void initListener() {
        puzzleGame.addGameStateListener(this);
    }


    @Override
    public void gameSuccess() {
        final SuccessDialog successDialog = new SuccessDialog();
        successDialog.show(getFragmentManager(), "successDialog");
        successDialog.addButtonClickListener(new SuccessDialog.OnButtonClickListener() {
        });
    }
}

