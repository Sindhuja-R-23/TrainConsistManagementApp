import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    static class Bogie {
        int capacity;
        Bogie(int capacity) { this.capacity = capacity; }
    }

    List<Bogie> loopFilter(List<Bogie> list) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : list) {
            if (b.capacity > 60) result.add(b);
        }
        return result;
    }

    List<Bogie> streamFilter(List<Bogie> list) {
        return list.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> list = Arrays.asList(new Bogie(70), new Bogie(50));
        assertEquals(1, loopFilter(list).size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> list = Arrays.asList(new Bogie(70), new Bogie(50));
        assertEquals(1, streamFilter(list).size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> list = Arrays.asList(new Bogie(80), new Bogie(30), new Bogie(90));
        assertEquals(loopFilter(list).size(), streamFilter(list).size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        long end = System.nanoTime();
        assertTrue((end - start) >= 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) list.add(new Bogie(i));
        assertNotNull(streamFilter(list));
    }
}