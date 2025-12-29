package com.backend;


public class Application {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting ... ");
        Guesser guesser = new Guesser();
        CodeGenerator generator = new CodeGenerator();
        Solver solver = new Solver(guesser, generator);
        solver.playGame();


    }
}
