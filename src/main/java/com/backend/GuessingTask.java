package com.backend;

import com.backend.data.entities.Colorcode;
import com.backend.data.entities.Feedback;
import com.backend.data.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class GuessingTask implements Runnable {

    private List<Colorcode> colorList;
    private Feedback feedback;
    private Colorcode lastGuess;
    private final List<Colorcode> sharedResult;


    GuessingTask(List<Colorcode> colorList, Feedback feedback, Colorcode lastGuess, List<Colorcode> sharedResult) {
        this.colorList = colorList;
        this.feedback = feedback;
        this.lastGuess = lastGuess;
        this.sharedResult = sharedResult;
    }

    @Override
    public void run() {

        Guesser guesser = new Guesser();

        for ( Colorcode colorListItem: colorList) {
            if (guesser.checkWhatIsCorrect(colorListItem, lastGuess).equals(feedback)) {
                synchronized (sharedResult) {
                    sharedResult.add(colorListItem);
                }
            }
        }


    }

}

