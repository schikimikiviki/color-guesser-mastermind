package com.backend;

import com.backend.data.entities.User;
import com.backend.data.enums.Color;

import java.util.*;

public class Guesser {

    public User initialize() {
        List<Color> colorList = new ArrayList<>();
        colorList.add(Color.GREEN);
        colorList.add(Color.BLUE);
        colorList.add(Color.BLUE);
        colorList.add(Color.RED);

        return new User(colorList);
    }


    // this function can be used to check if there are entries in the list that are already correct
    // it returns the number of correctly set fields
    public int checkWhatIsCorrect(List<Color> userList, List<Color> guessedList){

        int correctPinsCounter = 0;

        for (int i = 0; i < 4; i ++) {
        // we loop though the guessed list and check if something is correct
            if (guessedList.get(i).equals(userList.get(i))){
                correctPinsCounter ++;
            }
        }

        return correctPinsCounter;
    }

    // this can be used as final check to see if the list are equal if we have 4 correct pins
   public boolean checkIfWholeListIsCorrect (List<Color> userList, List<Color> guessedList) {
       return checkWhatIsCorrect(userList, guessedList) == 4;
   }



}
