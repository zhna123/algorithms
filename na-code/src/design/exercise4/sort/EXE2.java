package design.exercise4.sort;

/**
 * 4-2. [3] For each of the following problems, give an algorithm that finds the desired
 * numbers within the given amount of time. To keep your answers brief, feel free to
 * use algorithms from the book as subroutines. For the example, S = {6, 13, 19, 3, 8},
 * 19 − 3 maximizes the difference, while 8 − 6 minimizes the difference.
 * 
 * (a) Let S be an unsorted array of n integers. Give an algorithm that finds the pair
 * x, y ∈ S that maximizes |x−y|. Your algorithm must run in O(n) worst-case time.
 * 
 * get 3 element, compare and remove the middle one; then get the next, remove the middle one; .etc
 * until we found the max |x - y|
 * 
 * 
 * (b) Let S be a sorted array of n integers. Give an algorithm that finds the pair
 * x, y ∈ S that maximizes |x − y|. Your algorithm must run in O(1) worst-case time.
 * 
 * S[n] - S[1]
 * 
 * 
 * (c) Let S be an unsorted array of n integers. Give an algorithm that finds the pair
 * x, y ∈ S that minimizes |x − y|, for x = y. Your algorithm must run in O(n log n)
 * worst-case time.
 * 
 * sort the array first. then loop through the array to find smallest |x - y|
 * 
 * (d) Let S be a sorted array of n integers. Give an algorithm that finds the pair
 * x, y ∈ S that minimizes |x − y|, for x = y. Your algorithm must run in O(n)
 * worst-case time.
 * 
 * loop through the array to find smallest |x - y|
 * 
 * @author nz026920
 * 
 */
public class EXE2 {

}
