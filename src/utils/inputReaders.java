package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class inputReaders {
    private static List<String> readInput(String filename) {
        /*
        Tried to return lines as a stream but due to try-with-resources this stream was autoclosed and not
        operable in the other methods.
         */
        try (Stream<String> lines = Files.lines(Path.of(filename))) {
            return lines.toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> readStringInput(String filename) {
        return readInput(filename);
    }

    public static List<Integer> readIntegerInput(String filename) {
        return readInput(filename).stream().map(Integer::valueOf).toList();
    }

    public static List<Integer> readSingleLineIntegerInput(String filename){
        return Arrays.stream(readInput(filename).get(0).split(",")).map(Integer::valueOf).toList();

    }

    public static List<Byte> readByteInput(String filename) {
        return readInput(filename).stream().map(Byte::valueOf).toList();
    }
}
