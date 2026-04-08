import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    int totalSeats(List<Bogie> list) {
        return list.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 50),
                new Bogie("B", 60)
        );

        assertEquals(110, totalSeats(list));
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 30),
                new Bogie("B", 40),
                new Bogie("C", 50)
        );

        assertEquals(120, totalSeats(list));
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 70)
        );

        assertEquals(70, totalSeats(list));
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        assertEquals(0, totalSeats(list));
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 20),
                new Bogie("B", 30)
        );

        assertEquals(50, totalSeats(list));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 10),
                new Bogie("B", 20),
                new Bogie("C", 30)
        );

        assertEquals(60, totalSeats(list));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("A", 40));

        totalSeats(list);

        assertEquals(1, list.size());
    }
}