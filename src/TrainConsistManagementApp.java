import java.util.*;
import java.util.stream.*;

class Bogie {
    int capacity;

    Bogie(int capacity) {
        this.capacity = capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC13 - Performance Comparison");
        System.out.println("====================================\n");

        List<Bogie> bogies = new ArrayList<>();

        // Create sample data
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie((int)(Math.random() * 100)));
        }

        // LOOP METHOD
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();

        // STREAM METHOD
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();

        // OUTPUT
        System.out.println("Loop Time: " + (endLoop - startLoop) + " ns");
        System.out.println("Stream Time: " + (endStream - startStream) + " ns");

        System.out.println("\nUC13 performance comparison completed...");
    }
}