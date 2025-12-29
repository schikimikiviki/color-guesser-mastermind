package com.backend;

import com.backend.data.entities.Colorcode;
import com.backend.data.entities.Feedback;
import com.backend.data.entities.User;

import java.util.ArrayList;
import java.util.List;



public class Solver {

    int NUMBER_OF_THREADS = 4;  // this will also be used as number of sublists created
    Guesser guesser;
    CodeGenerator codeGenerator;

    public Solver(Guesser guesser, CodeGenerator codeGenerator) {
        this.guesser = guesser;
        this.codeGenerator = codeGenerator;
    }

    // this can be used to create sublists
    public List<List<Colorcode>> splitListIntoSubLists(List<Colorcode> list, int numberOfSublists) {
        List<List<Colorcode>> result = new ArrayList<>();
        int chunkSize = (int) Math.ceil((double) list.size() / numberOfSublists);

        for (int i = 0; i < list.size(); i += chunkSize) {
            int end = Math.min(i + chunkSize, list.size());
            result.add(new ArrayList<>(list.subList(i, end)));
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

                List<List<Colorcode>> subLists = splitListIntoSubLists(listOfAllColorCodes, NUMBER_OF_THREADS);

                List<Thread> threads = new ArrayList<>();

                // devide the list into n parts to use threads
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
