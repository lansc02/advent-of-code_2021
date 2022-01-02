package day5;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestVentline {

    @Test
    public void TestHorizontalVentline(){
        Coordinate start = new Coordinate(1, 2);
        Coordinate end = new Coordinate(1, 5);
        Ventline test = new Ventline(start, end);
        assert(test.start.x == start.x);
        assert(test.start.y == start.y);
    }

    @Test
    public void TestVerticalVentline(){
        Coordinate start = new Coordinate(1, 2);
        Coordinate end = new Coordinate(5, 2);
        Ventline test = new Ventline(start, end);
        assert(test.start.x == start.x);
        assert(test.start.y == start.y);
    }

    @Test
    public void TestSwappedStartEnd(){
        //Day5x2 thsi fails because the implementation changed
        Coordinate end = new Coordinate(1, 2);
        Coordinate start = new Coordinate(5, 2);
        Ventline test = new Ventline(start, end);
        assert(test.start.x == 1);
        assert(test.end.x == 5);
    }

    @Test
    public void TestPointCount(){
        Coordinate start = new Coordinate(1, 2);
        Coordinate end = new Coordinate(1, 5);
        Ventline test = new Ventline(start, end);
        assert(test.points.size() == 4);
    }

    @Test
    public void TestDiagonal(){
        Coordinate start = new Coordinate(1,1);
        Coordinate end = new Coordinate(3,3);
        Ventline testLine = new Ventline(start, end);
        ArrayList<Coordinate> expected = new ArrayList<>(Arrays.asList(
                new Coordinate(1,1),
                new Coordinate(2,2),
                new Coordinate(3,3)));
        assert testLine.points.containsAll(expected);
        assert expected.containsAll(testLine.points);
        }
    }

