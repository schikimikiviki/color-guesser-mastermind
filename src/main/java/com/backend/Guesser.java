package com.backend;

import com.backend.data.entities.Feedback;
import com.backend.data.entities.User;
import com.backend.data.enums.Color;

import java.util.*;

public class Guesser {

    public User initialize() {
        List<Color> colorList = new ArrayList<>();
        // randomly choose 4 colors
        colorList.add(Color.values()[new Random().nextInt(Color.values().length)]);
        colorList.add(Color.values()[new Random().nextInt(Color.values().length)]);
        colorList.add(Color.values()[new Random().nextInt(Color.values().length)]);
        colorList.add(Color.values()[new Random().nextInt(Color.values().length)]);

        System.out.println("Randomly chosen color List is: " + (Arrays.toString(colorList.toArray())));
        return new User(colorList);
    }


    // this function can be used to check if there are entries in the list that are already correct
    // it returns the number of correctly set fields
    public Feedback checkWhatIsCorrect(List<Color> secretList, List<Color> guessedList) {

        int correctPositionAndColor = 0; // exact matches
        int correctColor = 0;

        for (int i = 0; i < secretList.size(); i++) {
            // we loop though the guessed list and check if something is correct
            if (guessedList.get(i).equals(secretList.get(i))) {
                correctPositionAndColor++;
            } else if (secretList.contains(guessedList.get(i))) { // color is there but on wrong position
                correctColor++;
            }
        }

        return new Feedback(correctPositionAndColor, correctColor);
    }

    // this can be used as final check to see if the list are equal if we have 4 correct pins
    public boolean checkIfWholeListIsCorrect(List<Color> secretList, List<Color> guessedList) {
        Feedback feedback = checkWhatIsCorrect(secretList, guessedList);
        return feedback.getCorrectPosition() == 4;
    }


}
