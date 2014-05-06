package com.anotheria.net.bootcamp.magicsquare.singleThread.main;

import com.anotheria.net.bootcamp.magicsquare.MagicSquareMaker;
import com.anotheria.net.bootcamp.magicsquare.MagicSquareWriter;
import com.anotheria.net.bootcamp.magicsquare.Square;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
        String fileName = "n=" + N + ".txt";
        try(PrintWriter printWriter = new PrintWriter(new File(fileName).getAbsoluteFile()))
        {
            MagicSquareWriter msw = new MagicSquareWriter(printWriter);
            MagicSquareMaker msm = new MagicSquareMaker(new Square(N), msw);

            msm.makeMagicSquare();
        }catch (IOException e){
            // ignored
        }
    }
}
