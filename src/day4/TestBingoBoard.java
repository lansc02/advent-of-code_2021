package day4;

import day4.exceptions.BingoBoardException;
import day4.exceptions.NegativeValueException;
import day4.exceptions.OutofBoundsException;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestBingoBoard {

    @Test
    public void addValue() throws BingoBoardException {
        BingoBoard testBoard = new BingoBoard();
        testBoard.setPosition(2,2,10);
        assertEquals(10, testBoard.getPosition(2,2));
    }

    @Test
    public void addOutOfBoundsValue() {
        BingoBoard testBoard = new BingoBoard();
        assertThrows(BingoBoardException.class, () -> testBoard.setPosition(10, 10, 2));
    }

    @Test
    public void negativeValue(){
        BingoBoard testbboard = new BingoBoard();
        assertThrows(BingoBoardException.class, ()-> testbboard.setPosition(2,2,-3));
    }
}
