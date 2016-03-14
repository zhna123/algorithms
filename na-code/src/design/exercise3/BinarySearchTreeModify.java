package design.exercise3;

/**
 * 3-8
 * Design a data structure to support the following operations:
 * • insert(x,T) – Insert item x into the set T .
 * • delete(k,T) – Delete the kth smallest element from T.
 * • member(x,T) – Return true iff x ∈ T .
 * All operations must take O(log n) time on an n-element set.
 * 
 * We use binary search tree to implement this with 2 counters added to indicate the number of left/right nodes
 * respectively.
 * To insert: insert as regular insertion into a binary search tree, and increment counters.
 * To find member: binary search
 * To delete kth smallest element: use counters.left+root+right to get kth
 * it is basically a binary search again
 * All of these can be achieved in O(log(n))
 * 
 * 
 * @author nz026920
 * 
 */
public class BinarySearchTreeModify {

}
