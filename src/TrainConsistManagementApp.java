import java.util.*;

class Bogie {
    String type;
    String cargo;

    Bogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC12 - Safety Compliance Check");
        System.out.println("====================================\n");

        // Create list of goods bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Cylindrical", "Petroleum")); // valid
        bogies.add(new Bogie("Open", "Coal"));             // valid
        bogies.add(new Bogie("Box", "Grain"));             // valid

        // ❌ Test invalid case (uncomment to test)
        // bogies.add(new Bogie("Cylindrical", "Coal"));

        // STREAM VALIDATION
        boolean isSafe = bogies.stream().allMatch(b -> {
            if (b.type.equals("Cylindrical")) {
                return b.cargo.equals("Petroleum");
            }
            return true;
        });

        // OUTPUT
        if (isSafe) {
            System.out.println("Train is SAFETY COMPLIANT ✅");
        } else {
            System.out.println("Train is NOT SAFE ❌");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}