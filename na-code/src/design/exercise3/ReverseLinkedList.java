package design.exercise3;

/**
 * 3-2
 * reverse a singly linked list with linear time
 * 
 * @author nz026920
 * 
 */
public class ReverseLinkedList {

    // recursion
    public Node reverse(final Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        final Node second = head.next;
        head.next = null;
        final Node rest = reverse(second);
        second.next = head;
        return rest;
    }

    // iterative
    public Node reverse_1(final Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node p1 = head;
        Node p2 = head.next;
        head.next = null;
        while (p2 != null) {
            final Node tmp = p2.next;
            p2.next = p1;
            if (tmp != null) {
                p1 = p2;
                p2 = tmp;
            } else {
                break;
            }
        }
        return p2;
    }

    class Node {
        Node next;
        int data;
    }

}
