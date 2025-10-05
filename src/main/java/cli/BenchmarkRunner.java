package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) throws IOException {
        if (args.length < 6) {
            System.out.println("Usage: java -jar <jarfile> selection results.csv 100 10000 2 3");
            return;
        }

        String algorithm = args[0];
        String outputFile = args[1];
        int minN = Integer.parseInt(args[2]);
        int maxN = Integer.parseInt(args[3]);
        int factor = Integer.parseInt(args[4]);
        int trials = Integer.parseInt(args[5]);

        try (FileWriter fw = new FileWriter(outputFile)) {
            fw.write(PerformanceTracker.csvHeader() + "\n");

            for (int n = minN; n <= maxN; n *= factor) {
                for (int t = 0; t < trials; t++) {
                    int[] a = randomArray(n);
                    PerformanceTracker tracker = new PerformanceTracker();

                    long start = System.nanoTime();
                    SelectionSort.sort(a, tracker);
                    long end = System.nanoTime();

                    long time = end - start;
                    fw.write(tracker.toCsvLine("selection", n, time) + "\n");
                }
                System.out.println("Done: n=" + n);
            }
        }
        System.out.println("Benchmark finished. Results saved in " + outputFile);
    }

    private static int[] randomArray(int n) {
        Random r = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt(10000);
        return a;
    }
}
