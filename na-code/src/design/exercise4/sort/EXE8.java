package design.exercise4.sort;

/**
 * 4-8. [4 ] Given a set of S containing n real numbers, and a real number x. We seek an
 * algorithm to determine whether two elements of S exist whose sum is exactly x.
 * (a) Assume that S is unsorted. Give an O(n log n) algorithm for the problem.
 * 
 * 1.sort the arry cost Onlogn
 * 2. loop through the array, and do binary search for x - num1
 * total cost is nlogn + nlogn = 2nlogn = Onlogn
 * 
 * (b) Assume that S is sorted. Give an O(n) algorithm for the problem
 * 
 * use an additional array with values as x - num1
 * then loop through the 2 arrays, until find the matched same value, or return if not found
 * 
 * other solutions include using two pointers, one start from beginning, the other start from end.
 * 
 * 
 * @author nz026920
 * 
 */
public class EXE8 {

}
