# Assignment 2 – Algorithm Benchmark and Analysis

## About the Project
This project is part of **Assignment 2**.  
It focuses on testing and analyzing classic sorting algorithms.  
I worked on **Selection Sort**, and my partner worked on **Insertion Sort**.  

The goal was to:
- Implement a working sorting algorithm (Selection Sort).  
- Measure time, comparisons, swaps, and memory accesses.  
- Save benchmark results in CSV format.  
- Create charts and compare with my partner’s algorithm.  


## ⚙️ How to Run

### Build the project
```bash
mvn clean package
```
## Run benchmark
```
java -jar target/assignment2-selection-1.0-SNAPSHOT.jar selection results.csv 100 6400 2 3
```
## Arguments:
algorithm name (selection)

output file name (for example, results.csv)

minimum array size (100)

maximum array size (6400)

growth factor (2)

number of trials (3)

The program creates random arrays, sorts them using Selection Sort, and saves the results to a .csv file.

## Benchmark Results

The benchmark recorded four main metrics:
time_ns: total execution time (nanoseconds)
comparisons: number of comparisons
swaps: number of swaps
array_accesses: memory read/write operations
Each test was repeated 3 times for better accuracy.

## Plots
![Execution Time](images/selection_time.png)
![Comparisons](images/selection_comparisons.png)
![Array Accesses](images/selection_accesses.png)

## Analysis

From the results, we can clearly see the expected O(n²) behavior of Selection Sort.

Execution Time:
The running time grows quickly as n increases.
Doubling the array size roughly increases time by about four times, showing quadratic growth.

Comparisons:
The number of comparisons also grows by approximately n² / 2.
Selection Sort always performs the same number of comparisons, even if the array is already sorted.

Swaps:
The number of swaps is small — only one per loop iteration.
This makes Selection Sort efficient when swaps are expensive.

Array Accesses:
The number of array reads/writes grows in proportion to n²,
confirming the same theoretical complexity as expected.

## Conclusion

Selection Sort works correctly and behaves exactly as theory predicts.
The results confirm O(n²) complexity.
It’s easy to understand, stable in behavior, and useful for learning algorithm analysis.

## Tests

All functions were verified with JUnit 5 unit tests.
Each test checks that the array is correctly sorted and no errors occur.

To run tests inside IntelliJ IDEA:
Open the test file SelectionSortTest.java.
Right-click inside the editor → Run 'SelectionSortTest'.
All tests should pass (green).

```

```
