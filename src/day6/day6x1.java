package day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day6x1 {
    public static void main(String[] args) {
        //List<Integer> lanternfish = new ArrayList<>(Arrays.asList(3, 4, 3, 1, 2));
        List<Integer> lanternfish = utils.inputReaders.readSingleLineIntegerInput("src/day6/day6x1.txt");
        System.out.println(lanternfish);
        int days = 1;
        while (days <= 256){
            List<Integer> nextDaysFish = new ArrayList<>();
            for (Integer fish:lanternfish) {
               if (0<fish){
                   nextDaysFish.add(fish-1);
               }
               else if (fish == 0){
                   nextDaysFish.add(8);
                   nextDaysFish.add(6);
               }
            }
           // System.out.println("Day "+days+ ": "+ nextDaysFish);
            System.out.println("Day "+ days + ": " + nextDaysFish.size() + " fish");
            lanternfish = nextDaysFish;
            days++;
        }
    }
}

