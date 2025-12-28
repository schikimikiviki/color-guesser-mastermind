package com.backend;

import com.backend.data.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class GuessingTask implements Runnable {

    private List<List<Color>> colorList;
    private int feedback;
    private List<Color> lastGuess;


    GuessingTask(List<List<Color>> colorList, int feedback, List<Color> lastGuess) {
        this.colorList = colorList;
        this.feedback = feedback;
        this.lastGuess = lastGuess;
    }

    @Override
    public void run() {
        List<List<Color>> listOfCorrectGuesses = new ArrayList<>();
        Guesser guesser = new Guesser();

        for ( List<Color> colorListItem: colorList) {
            if (guesser.checkWhatIsCorrect(colorListItem, lastGuess) == feedback) {
                listOfCorrectGuesses.add(colorListItem);
            }
        }


    }

}

