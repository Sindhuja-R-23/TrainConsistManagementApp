import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // inside main()
        List<String> bogies = new ArrayList<>();
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        System.out.println("Bogies after insertion: " + bogies);

        bogies.remove("AC Chair");
        System.out.println("After removal: " + bogies);

        System.out.println("Contains Sleeper? " + bogies.contains("Sleeper"));


    }
}
