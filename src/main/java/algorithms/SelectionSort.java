package algorithms;

import metrics.PerformanceTracker;

public class SelectionSort {

    public static void sort(int[] a, PerformanceTracker t) {
        if (a == null || a.length <= 1) return;

        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                t.incComparisons();
                t.incArrayAccesses(2);
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
                t.incSwaps();
                t.incArrayAccesses(4);
            }
        }
    }
}
