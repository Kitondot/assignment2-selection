package metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;

    public void reset() {
        comparisons = swaps = arrayAccesses = 0;
    }

    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }
    public void incArrayAccesses(long count) { arrayAccesses += count; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }

    public String toCsvLine(String algorithm, int n, long timeNs) {
        return String.format("%s,%d,%d,%d,%d", algorithm, n, timeNs, comparisons, swaps, arrayAccesses);
    }

    public static String csvHeader() {
        return "algorithm,n,time_ns,comparisons,swaps,array_accesses";
    }
}
