package day6;

import java.math.BigInteger;
import java.util.*;

public class day6x1 {
    public static void main(String[] args) {
        //List<Integer> lanternfish = new ArrayList<>(Arrays.asList(3, 4, 3, 1, 2));
        List<Integer> lanternfish = utils.inputReaders.readSingleLineIntegerInput("src/day6/day6x1.txt");
        System.out.println(lanternfish);
        Map<Integer, BigInteger> fishpond = new HashMap<>();
        for (Integer fish:lanternfish) {
           if (fishpond.containsKey(fish)){
               BigInteger fishcount = fishpond.get(fish);
               fishcount = fishcount.add(BigInteger.valueOf(1));
               fishpond.put(fish, fishcount);
           }
           else {
               fishpond.put(fish, BigInteger.valueOf(1));
           }
        }
        int days = 1;
        while (days <= 256){
            HashMap<Integer, BigInteger> newpond = new HashMap<>();
            for (Integer key:fishpond.keySet()) {
                if (key == 0){
                    newpond.put(6, fishpond.get(0));
                    newpond.put(8, fishpond.get(0));
                }

                else if (0<key){
                    BigInteger newStock = fishpond.get(key);
                    switch (key){
                        case 7:
                            if (newpond.containsKey(key-1)){
                                newStock = newStock.add(newpond.get(key-1));
                            }
                            break;
                    }
                    newpond.put(key-1, newStock);
                }
            }
            fishpond = newpond;
            System.out.println("Day "+days+": "+fishpond.values().stream().reduce(BigInteger.ZERO, BigInteger::add));
            days++;
        }
    }
}

