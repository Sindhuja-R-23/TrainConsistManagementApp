import java.util.stream.Collectors;
import java.util.TreeSet;
import java.util.*;
public class TrainConsistManagementApp {
    public static void main(String[] args) {
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity: " + totalSeats);}}