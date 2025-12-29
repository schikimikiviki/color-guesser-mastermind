package com.backend;

import com.backend.data.entities.Feedback;
import com.backend.data.entities.User;
import com.backend.data.enums.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


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



    public void playGame() throws InterruptedException {

        try {
            // initialize guesser and generate color codes
            User player = guesser.initialize();
            List<Color> secretColors = player.getChosenColorList();
            List<List<Color>> listOfAllColorCodes = codeGenerator.generateAllCodes();
            List<List<Color>> sharedResult = new ArrayList<>();

            // make ONE initial move so that we have feedback that we can use later in the threads
            List<Color> lastGuess = List.of(Color.RED, Color.RED, Color.GREEN, Color.GREEN);
            Feedback feedback = guesser.checkWhatIsCorrect(secretColors, lastGuess);

            // devide the list into 4 parts to use threads
            List<List<List<Color>>> subLists = splitListIntoSubLists(listOfAllColorCodes, 4);

            // make guess
            Thread t1 = new Thread(new GuessingTask(subLists.get(0), feedback, lastGuess, sharedResult));
            Thread t2 = new Thread(new GuessingTask(subLists.get(1), feedback, lastGuess, sharedResult));
            Thread t3 = new Thread(new GuessingTask(subLists.get(2), feedback, lastGuess, sharedResult));
            Thread t4 = new Thread(new GuessingTask(subLists.get(3), feedback, lastGuess, sharedResult));

            t1.start();
            t2.start();
            t3.start();
            t4.start();

            t1.join();
            t2.join();
            t3.join();
            t4.join();

            System.out.println("Solution is: " + (Arrays.toString(sharedResult.toArray())));

        } catch (Error e) {
            System.err.println("Error occured: " + e);
        }


    }
}
