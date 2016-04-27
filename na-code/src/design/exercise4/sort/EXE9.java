package design.exercise4.sort;

/**
 * 4-9. [4 ] Give an efficient algorithm to compute the union of sets A and B, where
 * n = max(|A|, |B|). The output should be an array of distinct elements that form
 * the union of the sets, such that they appear more than once in the union.
 * (a) Assume that A and B are unsorted. Give an O(n log n) algorithm for the
 * problem.
 * 
 * 1. sort set A (set should already have distinct items), and add to result array
 * 2. loop through array B; for each item, do a binary search in array A
 * 3. if not found, add it to result array
 * 
 * (b) Assume that A and B are sorted. Give an O(n) algorithm for the problem.
 * 
 * since A and B are already sorted, we only need to use 2 pointers for each array.
 * If A[i] < B[j] i++; if B[j]<A[i] j++ (add A[i] to result array)
 * when we find equals, skip the value.(don't add)
 * 
 * @author nz026920
 * 
 */
public class EXE9 {

}
