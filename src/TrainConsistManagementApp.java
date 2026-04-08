import java.util.*;
import java.util.stream.*;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String toString() {
        return name + "(" + capacity + ")";
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC8 - Filter Passenger Bogies");
        System.out.println("====================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 50));
        bogies.add(new Bogie("Second Sitting", 80));

        // FILTER: capacity > 70
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        System.out.println("Filtered Bogies:");
        System.out.println(filtered);
    }
}