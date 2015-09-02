package example;

import java.util.ArrayList;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(final int[] nums) {
        final ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        helper(nums, new boolean[nums.length], new ArrayList<Integer>(), res);

        return res;
    }

    private void helper(final int[] nums, final boolean[] used, final ArrayList<Integer> item, final ArrayList<ArrayList<Integer>> res) {
        if (nums.length == item.size()) {
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                item.add(nums[i]);
                // have to always try this number in every location
                helper(nums, used, item, res);

                item.remove(item.size() - 1);
                // reset after recursion
                used[i] = false;
            }
        }
    }
}
