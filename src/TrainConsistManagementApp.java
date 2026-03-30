import java.util.LinkedHashSet;
import java.util.Set;
public class TrainConsistManagementApp {
    public static void main(String[] args) {
        Set<String> bogies = new LinkedHashSet<>();
        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("Cargo");
        bogies.add("Guard");
        bogies.add("Sleeper"); // duplicate ignored

        System.out.println("Train Formation: " + bogies);}
}
