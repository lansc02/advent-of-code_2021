import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day1x2 {

    public static void calcrises(List<Integer> depthmeasurements){
        final int windowSize = 3;
        int counter=-1;
        int windowSum = 0;
        int lastSum = 0;
        for (int i = 0; i < depthmeasurements.size()-2; i++) {
            for (int j=i; j<(i+windowSize);j++){
                windowSum += depthmeasurements.get(j);
            }
            System.out.println("----------------------");
            System.out.println("WindowSum: "+windowSum);
            System.out.println("lastSum: "+lastSum);
            if (windowSum>lastSum){
                counter++;
                System.out.println("Countup!");
            }
            lastSum = windowSum;
            windowSum=0;
        }
        System.out.println("Counter: "+counter);
    }

    public static List<Integer> test(){
        List<Integer> depthMeasurements = new ArrayList<>();
        Collections.addAll(depthMeasurements, 199,200,208,210,200,207,240,269,260,263);
        return depthMeasurements;
    }

    public static void main(String[] args) {
       // List<Integer> depthMeasurements = test();
        List<Integer> depthMeasurements = utils.readIntegerInput("inputs/day1x1.txt");
        calcrises(depthMeasurements);
    }
}
