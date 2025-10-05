package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class SelectionSortTest {

    @Test
    public void testSimpleSort() {
        int[] a = {5, 3, 8, 1, 2};
        int[] expected = a.clone();
        Arrays.sort(expected);

        PerformanceTracker t = new PerformanceTracker();
        SelectionSort.sort(a, t);

        assertArrayEquals(expected, a);
    }

    @Test
    public void testEmptyArray() {
        int[] a = {};
        PerformanceTracker t = new PerformanceTracker();
        SelectionSort.sort(a, t);
        assertEquals(0, a.length);
    }

    @Test
    public void testAlreadySorted() {
        int[] a = {1, 2, 3, 4, 5};
        int[] expected = a.clone();
        PerformanceTracker t = new PerformanceTracker();
        SelectionSort.sort(a, t);
        assertArrayEquals(expected, a);
    }
}
