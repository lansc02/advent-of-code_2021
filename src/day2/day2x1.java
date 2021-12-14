package day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day2x1 {

    public static void calcPosition(List<String> subinstructions) {
        int horizontal = 0;
        int vertical = 0;

        for (String instr : subinstructions) {
            String direction = instr.split(" ")[0];
            int value = Integer.parseInt(instr.split(" ")[1]);
            switch (direction) {
                case "forward":
                    horizontal += value;
                    break;
                case "up":
                    vertical -= value;
                    break;
                case "down":
                    vertical += value;
                    break;
            }
        }
        System.out.println("Position: "+vertical+" Tiefe, "+horizontal+" Horizontal. \n Produkt: " +horizontal*vertical);
    }

    public static List<String> test() {
        List<String> testdata = new ArrayList<>();
        Collections.addAll(testdata, "forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2");
        return testdata;
    }

    public static void main(String[] args) {
        List<String> data = utils.inputReaders.readStringInput("inputs/day2.day2x1.txt");
        calcPosition(data);
    }
}
