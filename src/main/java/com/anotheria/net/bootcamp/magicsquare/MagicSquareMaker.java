package com.anotheria.net.bootcamp.magicsquare;

/**
 * Class MagicSquareMaker contains methods that forms magic square from square object.
 */
public class MagicSquareMaker {

    /**
     * Square object that used to form magic square.
     */
    private Square square;

    /**
     * MagicSquareWriter object that used to write magic square
     * to console and file.
     */
    private MagicSquareWriter magicSquareWriter;

    /**
     * Constructor.
     * @param square Square object that used to form magic square.
     * @param magicSquareWriter object that used to write magic square
     * to console and file.
     */
    public MagicSquareMaker(Square square, MagicSquareWriter magicSquareWriter) {
        this.square = square;
        this.magicSquareWriter = magicSquareWriter;
    }

    /**
     * Starts creating all magic squares.
     */
    public void makeMagicSquare(){
        fillRow(0,0);
        magicSquareWriter.writeSquareCount();
    }

    /**
     * Starts creating all magic squares, with first element in square.
     */
    public void makeMagicSquare(int firstElement){
        putSquareFirstElement(firstElement);
        fillRow(0,1);
    }

    /**
     * Put in square first element.
     * @param firstElement
     */
    public void putSquareFirstElement(int firstElement){
        square.putNumber(0,0, firstElement);
    }

    /**
     * Fills row until it become magic, then starts fill column.
     * When all rows is filled check on magic square.
     * @param rowNumber position in row.
     * @param colNumber position in column.
     */
    public void fillRow(int rowNumber, int colNumber) {
        int currentNumber = 0;
        while ((currentNumber = square.getNextFreeNumber(currentNumber)) != 0) {
            if (colNumber == square.size()) {
                if (square.isRowMagic(rowNumber))
                    fillColumn(rowNumber + 1, rowNumber);
                return;
            }

            square.putNumber(rowNumber, colNumber, currentNumber);

            if (colNumber == square.size() - 1)
                if (square.isMagic()) {
                    magicSquareWriter.writeSquareToFile(square);
                }

            fillRow(rowNumber, colNumber + 1);
            square.freeNumber(rowNumber, colNumber, currentNumber);
        }
    }

    /**
     * Fills column until it become magic, then starts fill row.
     * @param rowNumber position in row.
     * @param colNumber position in column.
     */
    public void fillColumn(int rowNumber, int colNumber) {
        int currentNumber = 0;
        while ((currentNumber = square.getNextFreeNumber(currentNumber)) != 0) {
            if (rowNumber == square.size()) {
                if (square.isColumnMagic(colNumber))
                    fillRow(colNumber + 1, colNumber + 1);
                return;
            }
            square.putNumber(rowNumber, colNumber, currentNumber);
            fillColumn(rowNumber + 1, colNumber);
            square.freeNumber(rowNumber, colNumber, currentNumber);
        }
    }

}
