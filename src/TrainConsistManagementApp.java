import java.util.Scanner;
import java.util.regex.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC11 - Regex Validation");
        System.out.println("====================================\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Train ID: ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = sc.nextLine();

        String trainRegex = "TRN-\\d{4}";
        String cargoRegex = "PET-[A-Z]{2}";

        boolean isTrainValid = Pattern.matches(trainRegex, trainId);
        boolean isCargoValid = Pattern.matches(cargoRegex, cargoCode);

        System.out.println("\nTrain ID: " + (isTrainValid ? "VALID" : "INVALID"));
        System.out.println("Cargo Code: " + (isCargoValid ? "VALID" : "INVALID"));

        System.out.println("\nUC11 validation completed...");
    }
}