package design.exercise3;

import java.util.ArrayList;
import java.util.List;

import design.exercise3.util.BST;
import design.exercise3.util.TreeNode;

/**
 * 3-10
 * Implement best-fit and worst-fit for bin-packing problem
 * (only implemented best-fit; worst-fit is similar)
 * 
 * @author nz026920
 * 
 */
public class BinPacking {

    // best-fit
    // double for loop, for each weight, check every bin
    // this method can get O(n^2)
    // n is the number of the weights
    public int getNumberOfBins(final List<Long> items) {

        final int totalItem = items.size();
        if (totalItem == 0) {
            return 0;
        }
        // list of bins
        final List<Bin> bins = new ArrayList<Bin>();
        for (int i = 0; i < totalItem; i++) {
            long min = 1;
            int binIndex = 0;
            for (int j = 0; j < bins.size(); j++) {
                if (bins.get(j).capacity < items.get(i)) {
                    continue;
                }
                if ((bins.get(j).capacity - items.get(i)) < min) {
                    min = bins.get(j).capacity - items.get(i);
                    binIndex = j;
                }
            }
            final Bin bin;
            if (min == 1) {
                bin = new Bin();
                bins.add(bin);
            } else {
                bin = bins.get(binIndex);
            }
            bin.weights.add(items.get(i));
            bin.capacity -= items.get(i);
        }

        return bins.size();

    }

    // using a binary search tree, this method can get O(nlog(n))
    // n is the number of weights
    // the idea is to sort the bins based on the remaining space using a binary search tree
    // for each weight, traverse the tree to get the node with minimum space after inserting the weight
    // then re-insert this node (delete then insert)
    public int bestFit(final long[] w) {

        final BST bst = new BST();
        // initialize a root
        bst.root = new TreeNode(w[0], null, null);
        final int numOfWeights = w.length;
        int binCount = 0;

        for (int i = 0; i < numOfWeights; i++) {
            // check bins for each weight
            final long weight = w[i];
            long minDiff = 1;
            // get the new root each iteration
            TreeNode node = bst.root;
            TreeNode minNode = null;

            while (node != null) {
                // compare bin left space and current weight
                if (node.value > weight) {
                    final long diff = node.value - weight;
                    if (diff < minDiff) {
                        minDiff = diff;
                        minNode = node;
                        node = node.left;
                    } else {
                        throw new RuntimeException("something is wrong. this shouldn't happen and there shouldn't be duplicates in binary search tree.");
                    }
                } else {
                    node = node.right;
                }
            }

            if (minNode == null) {
                binCount++;
                final TreeNode newNode = new TreeNode(1 - weight, null, null);
                bst.insert(newNode.value);
            } else {
                minNode.value -= weight;
                bst.remove(minNode.value);
                bst.insert(minNode.value);
            }

        }

        return binCount;

    }

}

class Bin {
    int capacity;
    List<Long> weights;
}
