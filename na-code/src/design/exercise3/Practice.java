package design.exercise3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import design.exercise3.util.TreeNode;

public class Practice {

    // 3-18. [3] What method would you use to look up a word in a dictionary?
    // A: Binary search

    // 3-19. [3] Imagine you have a closet full of shirts. What can you do to organize your shirts
    // for easy retrieval?
    // A: Organize by color; then do a binary search

    // 3-20. [4] Write a function to find the middle node of a singly-linked list.
    public Node findMiddle(final Node head) {
        Node cur = head;
        Node middle = head;
        int k = 0;
        while (cur != null) {
            cur = cur.next;
            k++;
            if (k % 2 == 0) {
                middle = middle.next;
            }
        }
        return middle;
    }

    // 3-21. [4] Write a function to compare whether two binary trees are identical. Identical
    // trees have the same key value at each position and the same structure.

    public boolean compareBinaryTree(final TreeNode t1, final TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if ((t1 != null && t2 == null) || (t2 != null && t1 == null)) {
            return false;
        }
        return (t1.value == t2.value)
                && compareBinaryTree(t1.left, t2.left)
                && compareBinaryTree(t1.right, t2.right);
    }

    // 3-22. [4] Write a program to convert a binary search tree into a linked list.
    public List<Long> convertToLinkedList(final TreeNode t) {
        // pre-traversal the tree
        if (t == null) {
            return Collections.emptyList();
        }
        final List<Long> list = new LinkedList<Long>();
        traversal(t, list);
        return list;
    }

    private void traversal(final TreeNode t, final List<Long> list) {
        if (t.left != null) {
            traversal(t.left, list);
            list.add(t.value);
            if (t.right != null) {
                traversal(t.right, list);
            }
        }
    }

    // 3-23. [4] Implement an algorithm to reverse a linked list. Now do it without recursion.

    public List<Node> reverseList(final LinkedList<Node> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        final Node head = list.element();
        if (head == null || head.next == null) {
            return Collections.singletonList(head);
        }
        final LinkedList<Node> newList = reverse(head);
        return newList;
    }

    public LinkedList<Node> reverse(final Node head) {
        final Node second = head.next;
        head.next = null;
        final LinkedList<Node> newList = reverse(second);
        second.next = head;

        return newList;
    }

    // iterative method
    public List<Node> reverseList1(final LinkedList<Node> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        final Node head = list.element();
        if (head == null || head.next == null) {
            return Collections.singletonList(head);
        }
        // TODO iterative method
        return null;
    }

    // 3-24. [5] What is the best data structure for maintaining URLs that have been visited by
    // a Web crawler? Give an algorithm to test whether a given URL has already been
    // visited, optimizing both space and time.

    // can use hashtable. using hash function to look up hashtable. worse case is O(n)--all values hashed to one
    // key; best case is O(1)
    // (can look up domain first, then path)

    // 3-25. [4] You are given a search string and a magazine. You seek to generate all the characters
    // in search string by cutting them out from the magazine. Give an algorithm
    // to efficiently determine whether the magazine contains all the letters in the search
    // string.

    // using a hashtable to store the counts of each letter; then loop through the search string inc/dec the counts

    // 3-26. [4] Reverse the words in a sentence—i.e., “My name is Chris” becomes “Chris is
    // name My.” Optimize for time and space.

    // 1) use a stack
    // 2) reverse the whole string, then reverse individual word string
    // TODO write function to reverse string

    // 3-27. [5] Determine whether a linked list contains a loop as quickly as possible without
    // using any extra storage. Also, identify the location of the loop.

    // move 2 pointers at different speed; if they meet, then there is a loop.

    // 3-28. [5] You have an unordered array X of n integers. Find the array M containing
    // n elements where Mi is the product of all integers in X except for Xi. You may
    // not use division. You can use extra memory. (Hint: There are solutions faster than
    // O(n2).)

    // 3-29. [6] Give an algorithm for finding an ordered word pair (e.g., “New York”) occurring
    // with the greatest frequency in a given webpage. Which data structures would you
    // use? Optimize both time and space.

    // hashtable store frequency

    // These programming challenge problems with robot judging are available at
    // http://www.programming-challenges.com or http://online-judge.uva.es.
    // 3-1. “Jolly Jumpers” – Programming Challenges 110201, UVA Judge 10038.
    // 3-2. “Crypt Kicker” – Programming Challenges 110204, UVA Judge 843.
    // 3-3. “Where’s Waldorf?” – Programming Challenges 110302, UVA Judge 10010.
    // 3-4. “Crypt Kicker II” – Programming Challenges 110304, UVA Judge 850.

}

class Node {
    int data;
    Node next;
}
