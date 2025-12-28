package com.backend;

import com.backend.data.entities.User;

public class Application {


    public static void main(String[] args) {

        System.out.println("Starting ... ");
        int number_of_moves = 0;
        Guesser guesser = new Guesser();
        User user = guesser.initialize();


    }
}
