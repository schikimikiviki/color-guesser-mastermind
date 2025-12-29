package com.backend;

import com.backend.data.entities.User;
import com.backend.data.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solver {

    Guesser guesser;
    CodeGenerator codeGenerator;

    public Solver(Guesser guesser, CodeGenerator codeGenerator) {
        this.guesser = guesser;
        this.codeGenerator = codeGenerator;
    }

    // this can be used to create sublists
    public List<List<List<Color>>> splitListIntoSubLists(
            List<List<Color>> list, int numberOfSubLists) {

        int chunkSize = (list.size() + numberOfSubLists - 1) / numberOfSubLists;

        return IntStream.range(0, numberOfSubLists)
                .mapToObj(i -> list.subList(
                        i * chunkSize,
                        Math.min((i + 1) * chunkSize, list.size())
                ))
                .toList();
    }



    public void playGame() {

        // initialize guesser and generate color codes
        User player = guesser.initialize();
        List<Color> secretColors = player.getChosenColorList();
        List<List<Color>> listOfAllColorCodes = codeGenerator.generateAllCodes();

        // make guess

        // first, devide the list into 4 parts to use threads


//        List<Color> listPartOne = new ArrayList<Color>();
//        List<Color> listPartTwo = new ArrayList<Color>();
//        List<Color> listPartThree = new ArrayList<Color>();
//        List<Color> listPartFour = new ArrayList<Color>();
//
//        Thread t1 = new Thread(new GuessingTask());
//        Thread t2 = new Thread(new GuessingTask());
//        Thread t3 = new Thread(new GuessingTask());
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//        for (List<Color> colorCode: listOfAllColorCodes){
//             // get feedback for this colorCode
//           int feedbackOnCorrectPins = guesser.checkWhatIsCorrect(secretColors, colorCode);
//
//        }

    }

//    Filter candidates:
//    Use CandidateFilterTask or similar logic to remove impossible codes.
//    Repeat until solved:
//    Keep guessing and filtering until only one candidate remains or the guess matches the secret code.
//    Outcome:
//    You end up with the correct code.
//    Along the way, the candidate list shrinks after each guess.
}
