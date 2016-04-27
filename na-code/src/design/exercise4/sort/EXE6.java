package design.exercise4.sort;

/**
 * 4-6. [3] Given two sets S1 and S2 (each of size n), and a number x, describe an O(n log n)
 * algorithm for finding whether there exists a pair of elements, one from S1 and one
 * from S2, that add up to x. (For partial credit, give a Θ(n^2) algorithm for this
 * problem.)
 * 
 * @author nz026920
 * 
 * 1. sort S1 (nlogn)
 * 2. loop through S2; for each value that is X-s2, do a binary search for the value in S1. (n + nlogn)
 * total cost nlogn
 * 
 */
public class EXE6 {

}
