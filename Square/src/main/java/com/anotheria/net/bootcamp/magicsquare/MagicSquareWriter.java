package com.anotheria.net.bootcamp.magicsquare;

import java.io.PrintWriter;

/**
 * This class contains method that used to write Square object in console and file.
 */
public class MagicSquareWriter {

    /**
     * Stream that used to write in file.
     */
    private PrintWriter printWriter;

    /**
     * Counter. Contains number of squares that was wrote in the file and console.
     */
    private int squareCount;

    /**
     * Constructor.
     * @param printWriter Stream that used to write in file.
     */
    public MagicSquareWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    /**
     * Writes square in the file and console.
     * @param square Square object that should be written.
     */
    public synchronized void writeSquareToFile(Square square) {
        for (int[] row : square.getArray()) {
            for (int num : row) {
                printWriter.print((num < 10 ? "  " : " ") + num);
                System.out.print((num < 10 ? "  " : " ") + num);
            }
            printWriter.print("\n");
            System.out.println();
        }
        printWriter.print("--------------\n");
        System.out.println("--------------");
        printWriter.flush();
        squareCount++;
    }

    /**
     * Writes int file and console, total number of squares that was wrote in the file and console.
     */
    public synchronized void writeSquareCount(){
        printWriter.print("Total magic squares: " + squareCount + "\n");
        System.out.println("Total magic squares: " + squareCount);
    }
}
