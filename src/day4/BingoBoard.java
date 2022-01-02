package day4;

import day4.exceptions.BingoBoardException;
import day4.exceptions.NegativeValueException;
import day4.exceptions.OutofBoundsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BingoBoard {
    final int rows;
    final int cols;
    int[][] values;
    boolean[][] marked;
    private final HashMap<Integer, ArrayList<Coordinate>> coordinateMap;
    boolean BINGO;

    public BingoBoard() {
        this.rows = 5;
        this.cols = 5;
        values = new int[rows][cols];
        marked = new boolean[rows][cols];
        coordinateMap = new HashMap<>();
        BINGO = false;
    }

    private void setCoordinateMap(int value, int row, int col){
        if (!coordinateMap.containsKey(value)){
            int[] coord = {row,col};
            ArrayList<Coordinate> coordList = new ArrayList<>();
            coordList.add(new Coordinate(row, col));
            coordinateMap.put(value, coordList);
        }
        else{
            ArrayList<Coordinate> coordList = coordinateMap.get(value);
            coordList.add(new Coordinate(row, col));
            coordinateMap.put(value,coordList);
        }
    }

    public ArrayList<Coordinate> getCoordinate(int value){
        if (coordinateMap.containsKey(value)){
            return coordinateMap.get(value);
        }
        return null;
    }

    public void setPositionToValue(int rowindex, int colindex, int value) throws BingoBoardException {
        try {
            if (rowindex >= rows || colindex >= cols) {
                throw new OutofBoundsException("This index is not on the Bingo Board");
            }
            if (value < 0) {
                throw new NegativeValueException("Value smaller than 0");
            }
            this.values[rowindex][colindex] = value;
            setCoordinateMap(value, rowindex, colindex);
        } catch (OutofBoundsException | NegativeValueException e) {
            throw new BingoBoardException(e.getMessage());
        }
    }

    public int getValueFromPosition(int rowindex, int colindex) throws OutofBoundsException {
        if (rowindex >= rows || colindex >= cols) {
            throw new OutofBoundsException("This index is not on the Bingo Board");
        }
        return this.values[rowindex][colindex];
    }

    @Override
    public String toString() {
        StringBuilder boardvalues = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boardvalues.append(this.values[i][j]);
                boardvalues.append(" ");
            }
            boardvalues.append("\n");
        }

        return "\nBingoBoard{\n" + "rows: " + rows + ", \n" + "cols: " + cols + ",\nvalues=\n" + boardvalues + "}\n";
    }

    public void setRow(int index, String textrow) {
        String[] row = textrow.strip().split(" +");
        Integer[] numbers = Arrays.stream(row).map(Integer::parseInt).toList().toArray(new Integer[row.length]);

        for (int i = 0; i < cols; i++) {
            try {
                setPositionToValue(index, i, numbers[i]);
            } catch (BingoBoardException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean markPositionForBingo(int colindex, int rowindex) {
        try {
            if (rowindex >= rows || colindex >= cols) {
                throw new OutofBoundsException("This index is not on the Bingo Board");
            }
        } catch (OutofBoundsException e) {
            e.printStackTrace();
        }
        marked[rowindex][colindex] = true;
        return true;
    }

    public void markValue(int value){
        ArrayList<Coordinate> coords = getCoordinate(value);
        if (coords != null) {
            for (Coordinate c:coords) {
                markPositionForBingo(c.getY(), c.getX());
            }
        }
    }

    private boolean isColBingo(int col){
        for (int i = 0; i < this.rows; i++) {
            boolean allmarked = true;
            if (!marked[i][col]){
                allmarked = false;
                return false;
            }
        }
        return true;
    }

    private boolean isRowBingo(int row){
        for (int i = 0; i < this.cols; i++) {
            boolean allmarked = true;
           if (!marked[row][i]){
               allmarked = false;
               return false;
           }
        }
        return true;
    }

    public boolean isBoardBingo(){
        for (int i = 0; i < rows; i++) {
            if (isRowBingo(i)){
                BINGO = true;
                return true;
            }
        }
        for (int i = 0; i < cols; i++) {
           if (isColBingo(i)){
               BINGO = true;
               return true;
           }
        }
        return false;
    }

    public int calcSum(int lastNumber){
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j]){
                    System.out.println("Summe: "+sum+" + "+values[i][j]);
                    sum+=values[i][j];
                }
            }

        }return sum*lastNumber;
    }
}
