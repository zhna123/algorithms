package design.exercise3;

/**
 * 3-12. [5] Suppose you are given an input set S of n numbers, and a black box that if
 * given any sequence of real numbers and an integer k instantly and correctly answers
 * whether there is a subset of input sequence whose sum is exactly k. Show how to
 * use the black box O(n) times to find a subset of S that adds up to k.
 * 
 * 
 * 1. put the set in bb, if it returns true, to step 2; if it returns false, sum k doesn't exist
 * 2. remove the 1st element, if it returns true, remove this element; if not, this element is necessary.
 * 3. keep doing step 2 for each element eventually set S shrink to a set that adds up to k
 * 
 * @author nz026920
 * 
 */
public class BlackBoxSum {

}
