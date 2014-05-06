package com.anotheria.net.bootcamp.magicsquare.multithreaded.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main class that contains dimension of magic square and entry point.
 */
public class Main {

    /**
     * Dimension of square
     */
    private static int N = 3;

    /**
     * Entry point.
     * @param args
     */
    public static void main(String[] args) {
        Main main = new Main();

        main.start();
    }

    /**
     * Starts creating all magic squares.
     * Rum MagicSquareWorker.
     */
    public void start(){
        String fileName = "n=" + N + ".txt";

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(new MagicSquareWorker(N, fileName));

        executor.shutdown();
    }
}
