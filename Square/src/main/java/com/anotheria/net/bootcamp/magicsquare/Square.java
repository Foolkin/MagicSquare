package com.anotheria.net.bootcamp.magicsquare;

/**
 * Class Square used to form magic square.
 * Contains methods to check is the square a magic.
 */
public class Square {
    /**
     * Dimension of the square.
     */
    private final int N;

    /**
     * Magic number.
     */
    private int M;

    /**
     * Max number in the square.
     */
    private int MAX_NUM;

    /**
     * Array that contains all numbers of the square.
     */
    private int[][] square;

    /**
     * Array that contains free numbers of the square.
     */
    private boolean[] freeNumbers;

    /**
     * Constructor.
     * @param N dimension of the square.
     */
    public Square(int N) {
        this.N = N;
        squareInit();
        setMaxNum();
        setMagicNumber();
        freeNumbersInit();
    }

    /**
     * Initialize the square.
     */
    public void squareInit() {
        square = new int[N][N];
        squareFill();
    }

    /**
     * Initializes free numbers
     */
    public void freeNumbersInit() {
        freeNumbers = new boolean[MAX_NUM + 1];
        freeNumFill();
    }

    /**
     * Checks if the square is magic.
     *
     * @return true square is magic.
     */
    public boolean isMagic() {
        boolean magic = false;
        for (int i = 0; i < square.length; i++) {
            magic = (
                    isRowMagic(i)
                            && isColumnMagic(i)
                            && leftDiagMagic()
                            && rightDiagMagic()
            );
            if (!magic)
                return false;
        }
        return magic;
    }

    /**
     * Checks if the right diagonal is magic.
     * @return true if right diagonal is magic.
     */
    public boolean rightDiagMagic() {
        return rightDiagSum() == M;
    }

    /**
     * Checks if the left diagonal is magic.
     * @return true if left diagonal is magic.
     */
    public boolean leftDiagMagic() {
        return leftDiagSum() == M;
    }

    /**
     * Checks if the column is magic.
     * @return true if column is magic.
     */
    public boolean isColumnMagic(int index) {
        return columnSum(index) == M;
    }

    /**
     * Checks if the row is magic.
     * @return true if row is magic.
     */
    public boolean isRowMagic(int index) {
        return rowSum(index) == M;
    }

    /**
     * Returns sum left diagonal elements.
     * @return sum left diagonal elements.
     */
    public int leftDiagSum() {
        int sum = 0;
        for (int i = 0, j = i; i < square.length; i++, j++) {
            sum += square[i][j];
        }
        return sum;
    }

    /**
     * Returns sum right diagonal elements.
     * @return sum right diagonal elements.
     */
    public int rightDiagSum() {
        int sum = 0;
        for (int i = square.length - 1, j = 0; i >= 0 && j <= square.length - 1; i--, j++) {
            sum += square[i][j];
        }
        return sum;
    }

    /**
     * Returns sum column elements.
     *
     * @param index column number.
     * @return sum column elements.
     */
    public int columnSum(int index) {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[i][index];
        }
        return sum;
    }

    /**
     * Returns sum of row elements.
     *
     * @param index row number
     * @return sum of elements.
     */
    public int rowSum(int index) {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[index][i];
        }
        return sum;
    }

    /**
     * Returns next free number
     *
     * @param number number after which should be next free number.
     * @return founded number or 0 if not found.
     */
    public int getNextFreeNumber(int number) {
        for (int i = number + 1; i <= MAX_NUM; i++)
            if (freeNumbers[i])
                return i;

        return 0;
    }

    /**
     * Takes given place on board, remembers taken number.
     *
     * @param vertical   given vertical number.
     * @param horizontal given horizontal number.
     * @param number     number to take.
     */
    public void putNumber(int vertical, int horizontal, int number) {
        square[vertical][horizontal] = number;
        freeNumbers[number] = false;
    }

    /**
     * Frees given place on board and given number.
     *
     * @param vertical   given vertical number.
     * @param horizontal given horizontal number.
     * @param number     number to free.
     */
    public void freeNumber(int vertical, int horizontal, int number) {
        square[vertical][horizontal] = 0;
        freeNumbers[number] = true;
    }

    /**
     * Fills free numbers by true.
     */
    public void freeNumFill() {
        for (int i = 1; i <= MAX_NUM; i++)
            freeNumbers[i] = true;
    }

    /**
     * Returns size of square.
     * @return size of square.
     */
    public int size() {
        return square.length;
    }

    /**
     * Fills the square by 0.
     */
    public void squareFill() {
        for (int i = 0; i < square.length; i++)
            for (int j = 0; j < square.length; j++)
                square[i][j] = 0;
    }

    /**
     * Returns the array of the square.
     * @return array of the square.
     */
    public int[][] getArray(){
        return square;
    }

    /**
     * Returns freeNumbers[].
     * @return freeNumbers[].
     */
    public boolean[] getFreeNumbers() {
        return freeNumbers;
    }

    /**
     * Returns max number in the square.
     * @return
     */
    public int getMAX_NUM() {
        return MAX_NUM;
    }

    /**
     * Sets the max number in the square.
     * MAX_NUM = N * N
     */
    public void setMaxNum() {
        MAX_NUM = N * N;
    }

    /**
     * Returns the magic number.
     * @return magic number.
     */
    public int getM() {
        return M;
    }

    /**
     * Sets the magic number.
     */
    public void setMagicNumber() {
        M = (N * (N * N + 1)) / 2;
    }

}
