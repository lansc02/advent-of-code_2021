package day4;

import day4.exceptions.BingoBoardException;
import day4.exceptions.NegativeValueException;
import day4.exceptions.OutofBoundsException;

import java.util.Arrays;

public class BingoBoard {
    final int rows;
    final int cols;
    int[][] values;
    boolean[][] marked;

    public BingoBoard() {
        this.rows = 5;
        this.cols = 5;
        values = new int[cols][rows];
        marked = new boolean[cols][rows];
    }

    public void setPosition(int rowindex, int colindex, int value) throws BingoBoardException {
        try {
            if (rowindex >= rows || colindex >= cols) {
                throw new OutofBoundsException("This index is not on the Bingo Board");
            }
            if (value < 0) {
                throw new NegativeValueException("Value smaller than 0");
            }
            this.values[colindex][rowindex] = value;
        }catch(OutofBoundsException | NegativeValueException e){
            throw new BingoBoardException(e.getMessage());
        }
    }

    public int getPosition(int rowindex, int colindex) throws OutofBoundsException{
        if (rowindex>=rows || colindex>=cols){
           throw new OutofBoundsException("This index is not on the Bingo Board");
        }
        return this.values[colindex][rowindex];
    }

    @Override
    public String toString() {
        return "BingoBoard{" + "rows:" + rows + ", \n" +
               "cols:" + cols + ",\nvalues=" + Arrays.toString(values) + '}';
    }

    public void setRow(int index, String textrow){
        String[] row = textrow.split(" ");
        Integer[] numbers = Arrays.stream(row)
                .map(Integer::parseInt)
                .toList()
                .toArray(new Integer[row.length]);

        for (int i = 0; i < cols; i++) {
            try {
                setPosition(index, i, numbers[i]);
            } catch (BingoBoardException e) {
                e.printStackTrace();
            }
        }
    }
}
