import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day1x1 {

    public static void calcDepthChanges(List<Integer> depthMeasurements) throws NullPointerException {
        if (depthMeasurements == null){
            throw new NullPointerException();
        }
        Integer before = depthMeasurements.get(0);
        int counter = 0;
        for (int i = 1; i < depthMeasurements.size(); i++) {
            int current = depthMeasurements.get(i);
            if (current > before) {
                counter++;
                System.out.println("Current: %s, before: %s,  depth increased".formatted(current, before));
            }
            before = current;
        }
        System.out.println(counter);
    }


    public static List<Integer> test() {
        List<Integer> depthMeasurements = new ArrayList<>();
        Collections.addAll(depthMeasurements, 199, 200, 208, 210, 200, 207, 240, 269, 260, 263);
        return depthMeasurements;
    }

    public static void main(String[] args) {
        List<Integer> depthMeasurements = utils.readIntegerInput("inputs/day1x1.txt");
        // List<Integer> depthMeasurements = test();
        calcDepthChanges(depthMeasurements);
    }
}

