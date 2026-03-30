import java.util.TreeSet;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        TreeSet<String> bogieIds = new TreeSet<>();
        bogieIds.add("Engine");
        bogieIds.add("Sleeper");
        bogieIds.add("AC");
        bogieIds.add("Cargo");
        bogieIds.add("Guard");

        System.out.println("Ordered Bogie IDs: " + bogieIds);
    }
}
