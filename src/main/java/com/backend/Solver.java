package com.backend;

import com.backend.data.entities.Colorcode;
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
    public List<List<Colorcode>> splitListIntoSubLists(List<Colorcode> list, int chunkSize) {
        List<List<Colorcode>> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i += chunkSize) {
            int end = Math.min(i + chunkSize, list.size());
            result.add(list.subList(i, end));
        }

        return result;
    }


    public void playGame() throws InterruptedException {

        try {
            // initialize guesser and generate color codes
            User player = guesser.initialize();
            Colorcode secretColors = player.getChosenColorList();
            List<Colorcode> listOfAllColorCodes = codeGenerator.generateAllCodes();


            // we iterate through this whole list
            while (listOfAllColorCodes.size() > 1) {

                // make ONE initial move so that we have feedback that we can use later in the threads
                Colorcode guess = listOfAllColorCodes.get(0);
                Feedback feedback = guesser.checkWhatIsCorrect(secretColors, guess);

                List<Colorcode> nextRound = new ArrayList<>();

                List<List<Colorcode>> subLists = splitListIntoSubLists(listOfAllColorCodes, 4);

                List<Thread> threads = new ArrayList<>();

                // devide the list into 4 parts to use threads
                for (List<Colorcode> colorList : subLists) {
                    Thread t = new Thread(new GuessingTask(colorList, feedback, guess, nextRound));
                    threads.add(t);
                    t.start();
                }

                for (Thread t : threads) {
                    t.join();
                }

                listOfAllColorCodes = nextRound;
            }

            System.out.println("Solution is: " + listOfAllColorCodes.get(0));


        } catch (Error e) {
            System.err.println("Error occured: " + e);
        }


    }
}
