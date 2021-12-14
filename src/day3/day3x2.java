package day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day3x2 {
    public static List<String> test() {
        List<String> testdata = new ArrayList<>();
        Collections.addAll(testdata, "00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010");
        return testdata;
    }

    public static void main(String[] args) {
        List<String> data = utils.inputReaders.readStringInput("inputs/day3.day3x1.txt");
        //List<String> data= test();
        List<String> o2 = calcLifeSupport(data, "o2", 0);
        System.out.println(Integer.valueOf(o2.get(0),2));
        List<String> co2 = calcLifeSupport(data, "co2", 0);
        System.out.printf("Life support rating: "+ Integer.valueOf(o2.get(0), 2) * Integer.valueOf(co2.get(0),
                2));
    }

    private static List<String> calcLifeSupport(List<String> data, String type, int position) {

        if (data.size() == 1) {
            return data;
        }
        List<String> result;
        List<String> ones = new ArrayList<>();
        List<String> zeroes = new ArrayList<>();

        for (String test : data) {
            if (test.charAt(position) == '0') {
                zeroes.add(test);
            } else if (test.charAt(position) == '1') {
                ones.add(test);
            }
        }

        boolean equal = false;
        List<String> max = new ArrayList<>();
        List<String> min = new ArrayList<>();

        if (ones.size() > zeroes.size()) {
            max.addAll(ones);
            min.addAll(zeroes);
        } else if (ones.size() < zeroes.size()) {
            max.addAll(zeroes);
            min.addAll(ones);
        } else {
            equal = true;
        }

        if (type.equalsIgnoreCase("co2")) {
            if (equal == true) {
                result = calcLifeSupport(zeroes, "co2", position+1);
            } else {
                result = calcLifeSupport(min, "co2", position+1);
            }
        } else if (type.equalsIgnoreCase("o2")) {
            if (equal == true) {
                result = calcLifeSupport(ones, "o2", position+1);
            } else {
                result = calcLifeSupport(max, "o2", position+1);
            }
        }
        else result = new ArrayList<>();

        return result;
    }

}


