package day5;

import org.junit.jupiter.api.Test;

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

}
