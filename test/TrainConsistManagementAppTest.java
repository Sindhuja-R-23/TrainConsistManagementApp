import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    static class Bogie {
<<<<<<< HEAD
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
=======
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
>>>>>>> feature/UC9
            this.capacity = capacity;
        }
    }

<<<<<<< HEAD
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
=======
    Map<String, List<Bogie>> group(List<Bogie> list) {
        return list.stream()
                .collect(Collectors.groupingBy(b -> b.type));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("Sleeper", 72)
        );

        assertEquals(2, group(list).get("Sleeper").size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> list = Arrays.asList(
                new Bogie("AC Chair", 60),
                new Bogie("AC Chair", 65)
        );

        assertEquals(2, group(list).get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("First Class", 50)
        );

        assertEquals(2, group(list).size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        assertTrue(group(list).isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70)
        );

        assertEquals(1, group(list).size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );

        Map<String, List<Bogie>> result = group(list);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("Sleeper", 72)
        );

        assertEquals(2, group(list).get("Sleeper").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 70));

        group(list);
>>>>>>> feature/UC9

        assertEquals(1, list.size());
    }
}