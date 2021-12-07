import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day3x1 {
    public static List<String> test() {
        List<String> testdata = new ArrayList<>();
        Collections.addAll(testdata,
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010");
        return testdata;
    }

    public static void main(String[] args) {
        List<String> data = utils.readStringInput("inputs/day3x1.txt");
        //List<String> data= test();
        calcPowerConsumption(data);
    }

    private static void calcPowerConsumption(List<String> data) {
        String epsilon = "";
        String gamma = "";
        final int fieldlength = data.get(0).length();

        int[] state = new int[fieldlength];

        for (String row:data) {
            String[] fields = row.split("");
            for (int i = 0; i < fieldlength; i++) {
                state[i] += Integer.parseInt(fields[i]);
            }
        }

        for (int field :state) {
           if (field<(data.size()*0.5)){
               gamma += '0';
               epsilon += '1';
           }
           else if (field > (data.size()*0.5)){
               gamma += '1';
               epsilon += '0';
           }
           else{
               System.out.println("This should not hava happened...");
           }
        }

        long igamma = Long.parseLong(gamma, 2);//.intValue();
        long iepsilon = Long.parseLong(epsilon,2);//.intValue();
        System.out.println("Gamma: "+ gamma+", "+ igamma);
        System.out.println("Epsilon: "+epsilon+", "+iepsilon);
        System.out.println("Power consumption: " + iepsilon*igamma );
    }
}
