package day4;

import day4.exceptions.BingoBoardException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestBingoBoard {

    @Test
    public void addValue() throws BingoBoardException {
        BingoBoard testBoard = new BingoBoard();
        testBoard.setPositionToValue(2,2,10);
        assertEquals(10, testBoard.getValueFromPosition(2,2));
    }

    @Test
    public void addOutOfBoundsValue() {
        BingoBoard testBoard = new BingoBoard();
        Exception e = assertThrows(BingoBoardException.class, () -> testBoard.setPositionToValue(5, 5, 2));
        assertEquals("This index is not on the Bingo Board", e.getMessage());
    }

    @Test
    public void negativeValue(){
        BingoBoard testBoard = new BingoBoard();
        Exception e = assertThrows(BingoBoardException.class, ()-> testBoard.setPositionToValue(2,2,-3));
        assertEquals("Value smaller than 0", e.getMessage());
    }

    @Test
    public void markValue(){
        BingoBoard testBoard = new BingoBoard();
        try {
            testBoard.setPositionToValue(1, 4, 25);
            testBoard.markPositionForBingo(1, 1);
            assert(testBoard.marked[1][1]);
        } catch (BingoBoardException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void coordinateExists(){
        BingoBoard testBoard = new BingoBoard();
        try {
            testBoard.setPositionToValue(1, 4, 25);
        } catch (BingoBoardException e) {
            e.printStackTrace();
        }
        ArrayList<Coordinate> expected =  new ArrayList<>();
        expected.add(new Coordinate(1,4));
        ArrayList<Coordinate> result = testBoard.getCoordinate(25);
        assertEquals(result.size(), expected.size());
        assertEquals(true, expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    public void coordinateDoesNotExist(){
        BingoBoard testBoard = new BingoBoard();
        try {
            testBoard.setPositionToValue(1, 4, 15);
        } catch (BingoBoardException e) {
            e.printStackTrace();
        }
        assertNull(testBoard.getCoordinate(25));
    }

    @Test
    public void BoardIsBingo(){
       BingoBoard testBoard = new BingoBoard();
       testBoard.setRow(1,"5 15 12 6 18");
       testBoard.markValue(5);
        testBoard.markValue(15);
        testBoard.markValue(12);
        testBoard.markValue(18);
        testBoard.markValue(6);
        assertTrue(testBoard.isBoardBingo());
    }
}
