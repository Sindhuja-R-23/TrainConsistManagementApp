import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    List<Bogie> filter(List<Bogie> list, int threshold) {
        return list.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 80),
                new Bogie("B", 60)
        );

        assertEquals(1, filter(list, 70).size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 70)
        );

        assertEquals(0, filter(list, 70).size());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 50)
        );

        assertTrue(filter(list, 70).isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 80),
                new Bogie("B", 90)
        );

        assertEquals(2, filter(list, 70).size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 40),
                new Bogie("B", 50)
        );

        assertTrue(filter(list, 70).isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 80),
                new Bogie("B", 90)
        );

        assertEquals(2, filter(list, 70).size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        assertTrue(filter(list, 70).isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("A", 80));

        filter(list, 70);

        assertEquals(1, list.size());
    }
}