import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    boolean validateTrain(String id) {
        return Pattern.matches("TRN-\\d{4}", id);
    }

    boolean validateCargo(String code) {
        return Pattern.matches("PET-[A-Z]{2}", code);
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(validateTrain("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(validateTrain("TRAIN12"));
        assertFalse(validateTrain("TRN12A"));
        assertFalse(validateTrain("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(validateCargo("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(validateCargo("PET-ab"));
        assertFalse(validateCargo("PET123"));
        assertFalse(validateCargo("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(validateTrain("TRN-123"));
        assertFalse(validateTrain("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(validateCargo("PET-ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(validateTrain(""));
        assertFalse(validateCargo(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(validateTrain("TRN-1234X"));
        assertFalse(validateCargo("PET-ABC"));
    }
}