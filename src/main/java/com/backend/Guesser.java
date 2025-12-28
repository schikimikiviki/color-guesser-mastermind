package com.backend;

import com.backend.data.entities.User;
import com.backend.data.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class Guesser {


    public User initialize() {
        List<Color> colorList = new ArrayList<>();
        colorList.add(Color.GREEN);
        colorList.add(Color.BLUE);
        colorList.add(Color.BLUE);
        colorList.add(Color.RED);

        return new User(colorList);
    }

    public List<Color> makeInitialGuess() {

        // initially, we can only really guess, because there is no indicator to know the colors

    }

   public boolean checkIfCorrect (List<Color> userList, List<Color> guessedList) {
       return userList.equals(guessedList);
   }

   public Color bruteforce(){
        // bruteforce to get a valid combination
   }

   public Color knuthsAlgorithm(){
       // see: https://stackoverflow.com/questions/62430071/donald-knuth-algorithm-mastermind

   }
}
