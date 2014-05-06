package com.anotheria.net.bootcamp.magicsquare.multithreaded.main;

import com.anotheria.net.bootcamp.magicsquare.MagicSquareMaker;
import com.anotheria.net.bootcamp.magicsquare.MagicSquareWriter;
import com.anotheria.net.bootcamp.magicsquare.Square;

/**
 * Runnable class, that run the creation of a magic square with a certain first element.
 */
public class MagicSquareThread implements Runnable {

    /**
     * Dimension of a magic square.
     */
    private int N;

    /**
     * First element of the square.
     */
    private int firstElement;

    /**
     * MagicSquareWriter which will write magic square in file.
     */
    private MagicSquareWriter magicSquareWriter;

    /**
     * Constructor.
     * @param N Dimension of a magic square.
     * @param firstElement First element of the square.
     * @param magicSquareWriter MagicSquareWriter which will write magic square in file.
     */
    public MagicSquareThread(int N, int firstElement, MagicSquareWriter magicSquareWriter) {
        this.N = N;
        this.firstElement = firstElement;
        this.magicSquareWriter = magicSquareWriter;
    }

    @Override
    public void run() {
        MagicSquareMaker msm = new MagicSquareMaker(new Square(N), magicSquareWriter);

        msm.makeMagicSquare(firstElement);
    }

}
