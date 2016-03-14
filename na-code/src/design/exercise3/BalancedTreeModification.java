package design.exercise3;

/**
 * 3-6
 * Modify a balanced tree to have predecessor and successor have O(1)
 * Data structure can achieve this: double linked list
 * so we can point each node in the tree to an entry in a double linked list
 * search, min and max operation didn't change (cost log(n))
 * in case of insert and delete, other than the time cost while traversing the tree(O(logn)),
 * they only need O(1) time to do so in a double linked list(change the pointers of the entries).
 * 
 * @author nz026920
 * 
 */
public class BalancedTreeModification {

}
