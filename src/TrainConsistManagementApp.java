import java.util.*;
import java.util.stream.*;

class Bogie {
<<<<<<< HEAD
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
=======
    String type;
    int capacity;

    Bogie(String type, int capacity) {
        this.type = type;
>>>>>>> feature/UC9
        this.capacity = capacity;
    }

    public String toString() {
<<<<<<< HEAD
        return name + "(" + capacity + ")";
=======
        return type + "(" + capacity + ")";
>>>>>>> feature/UC9
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("====================================");
<<<<<<< HEAD
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
=======
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("====================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("First Class", 50));

        // GROUPING
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));

        System.out.println("Grouped Bogies:");
        System.out.println(grouped);
>>>>>>> feature/UC9
    }
}