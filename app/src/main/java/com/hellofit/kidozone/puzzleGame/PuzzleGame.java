package com.hellofit.kidozone.puzzleGame;

import android.content.Context;
import com.hellofit.kidozone.R;
import com.hellofit.kidozone.ui.PuzzleLayout;

import androidx.annotation.NonNull;


public class PuzzleGame implements PuzzleLayout.SuccessListener {

    private PuzzleLayout puzzleLayou;
    private GameStateListener stateListener;
    private Context context;

    public void addGameStateListener(GameStateListener stateListener) {
        this.stateListener = stateListener;
    }

    public PuzzleGame(@NonNull Context context, @NonNull PuzzleLayout puzzleLayout) {
        this.context = context.getApplicationContext();
        this.puzzleLayou = puzzleLayout;
        puzzleLayou.addSuccessListener(this);
    }

    private boolean checkNull() {
        return puzzleLayou == null;
    }



    @Override
    public void success() {
        if (stateListener != null) {
            stateListener.gameSuccess();
        }
    }

    public interface GameStateListener {
        public void gameSuccess();
    }
}
