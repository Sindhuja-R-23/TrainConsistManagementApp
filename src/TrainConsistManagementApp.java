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

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Cylindrical", "Petroleum"));
        bogies.add(new Bogie("Open", "Coal"));
        bogies.add(new Bogie("Box", "Grain"));

        boolean isSafe = bogies.stream().allMatch(b -> {
            if (b.type.equals("Cylindrical")) {
                return b.cargo.equals("Petroleum");
            }
            return true;
        });

        System.out.println("Safety Status: " + (isSafe ? "SAFE" : "UNSAFE"));

        System.out.println("\nUC12 validation completed...");
    }
}