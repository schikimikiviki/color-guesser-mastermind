package com.backend;

import com.backend.data.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class GuessingTask implements Runnable {

    private List<List<Color>> colorList;
    private int feedback;
    private List<Color> lastGuess;
    private final List<List<Color>> sharedResult;


    GuessingTask(List<List<Color>> colorList, int feedback, List<Color> lastGuess, List<List<Color>> sharedResult) {
        this.colorList = colorList;
        this.feedback = feedback;
        this.lastGuess = lastGuess;
        this.sharedResult = sharedResult;
    }

    @Override
    public void run() {
        List<List<Color>> listOfCorrectGuesses = new ArrayList<>();
        Guesser guesser = new Guesser();

        for ( List<Color> colorListItem: colorList) {
            if (guesser.checkWhatIsCorrect(colorListItem, lastGuess) == feedback) {
                synchronized (sharedResult) {
                    sharedResult.add(colorListItem);
                }
            }
        }


    }

}

