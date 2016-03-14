package design.exercise3;

/**
 * 3-7
 * Suppose you have access to a balanced dictionary data structure, which supports each of the operations search,
 * insert, delete, minimum, maximum, successor, and predecessor in O(log n) time. Explain how to modify the insert and
 * delete operations so they still take O(log n) but now minimum and maximum take O(1) time. (Hint: think in terms of
 * using the abstract dictionary operations, instead of mucking about with pointers and the like.)
 * 
 * Balanced dictionary data structure, we can think of it as a balanced binary search tree.
 * To get min and max in O(1), store min value and max value.
 * to insert x: compare with min/max each time. If x<min, min=x; if x>max, max=x
 * to delete x: compare with min/max each time. If x=min, min=successor(x); if x=max, max=predecessor(x)
 * regular insert/delete operations(O(log(n))) plus the successor/predecessor operations(O(log(n))) is still log(n)
 * 
 * @author nz026920
 * 
 */
public class BalancedDictModify {

}
