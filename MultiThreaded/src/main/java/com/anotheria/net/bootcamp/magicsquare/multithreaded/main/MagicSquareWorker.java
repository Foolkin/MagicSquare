package com.anotheria.net.bootcamp.magicsquare.multithreaded.main;

import com.anotheria.net.bootcamp.magicsquare.MagicSquareWriter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Runnable class, that runs MagicSquareThreads.
 * Number of MagicSquareThreads equals N * N.
 */
public class MagicSquareWorker implements Runnable {

    /**
     * MagicSquare dimension.
     */
    private int N;

    /**
     * File name in which will be written results.
     */
    private String fileName;

    private ArrayList<Thread> threadList = new ArrayList<>(N * N);

    /**
     * Constructor.
     * @param N MagicSquare dimension.
     * @param fileName File name in which will be written results.
     */
    public MagicSquareWorker(int N, String fileName) {
        this.N = N;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try(PrintWriter printWriter = new PrintWriter((new File(fileName))))
        {
            MagicSquareWriter magicSquareWriter = new MagicSquareWriter(printWriter);

            for (int firstElement = 1; firstElement <= N * N; firstElement++) {
                Thread thread = new Thread(new MagicSquareThread(N, firstElement, magicSquareWriter));
                thread.start();
                threadList.add(thread);
            }

            waitAllThreads();

            magicSquareWriter.writeSquareCount();

        }catch (IOException e){
            throw new RuntimeException("can't write to the file", e);
        }
    }

    /**
     * Making loop until last Thread stops.
     */
    public void waitAllThreads(){
        while(threadList.size() != 0){
            Iterator<Thread> it = threadList.iterator();
            while (it.hasNext())
                if(!it.next().isAlive())
                    it.remove();
        }
    }
}
