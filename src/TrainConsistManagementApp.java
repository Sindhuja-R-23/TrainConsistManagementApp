import java.util.stream.Collectors;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        System.out.println("Grouped Bogies: " + grouped);}}