package day5;

import utils.inputReaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day5x2 {
    public static void main(String[] args) {
        //List<String> input = inputReaders.readStringInput("src/day5/day5x1test.txt");
        List<String> input = inputReaders.readStringInput("src/day5/day5x1.txt");
        List<Ventline> ventlines = new ArrayList<>();
        Map<Coordinate, Integer> pointmap = new HashMap<>();
        for (String i : input) {
            String[] segment = i.split(" -> ");
            Ventline ventline = new Ventline(new Coordinate(segment[0]), new Coordinate(segment[1]));
            ventlines.add(ventline);
        }
        for (Ventline line : ventlines) {
            for (Coordinate point : line.points) {
                if (pointmap.containsKey(point)) {
                    int value = pointmap.get(point);
                    value = value + 1;
                    pointmap.put(point, value);
                } else {
                    pointmap.put(point, 1);
                }
            }
        }
        long count = pointmap.entrySet().stream().filter(e -> e.getValue() > 1).count();
        System.out.println(count);

    }
}

