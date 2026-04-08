import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    static class Bogie {
        String type;
        String cargo;

        Bogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    boolean checkSafety(List<Bogie> list) {
        return list.stream().allMatch(b -> {
            if (b.type.equals("Cylindrical")) {
                return b.cargo.equals("Petroleum");
            }
            return true;
        });
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Open", "Coal")
        );

        assertTrue(checkSafety(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Cylindrical", "Coal")
        );

        assertFalse(checkSafety(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Open", "Grain"),
                new Bogie("Box", "Coal")
        );

        assertTrue(checkSafety(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Cylindrical", "Coal")
        );

        assertFalse(checkSafety(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        assertTrue(checkSafety(list));
    }
}