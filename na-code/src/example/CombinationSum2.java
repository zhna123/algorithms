package example;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the
 * candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 * 
 */
public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum2(final int[] candidates, final int target) {
        final ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(final int[] candidates, final int start, final int target, final ArrayList<Integer> item, final ArrayList<ArrayList<Integer>> res) {

        // has to check this first. because even start>=candidates.length, we can still return
        if (target == 0) {
            res.add(new ArrayList<Integer>(item));
            return;
        }

        if (target < 0 || start >= candidates.length) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // here i>start but not i>0 is because we still have to consider repeated elements
            // i>0 will remove any repeated elements
            // i> start will happen when a combination try failed, the recursion returned
            // at this point we already considered the repeated elements in the last recursion
            // so if we meet any repeated elements again, we need to skip it
            // in order not to have duplicate combinations
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            item.add(candidates[i]);
            // i increase 1 is because we can only use one number once
            helper(candidates, i + 1, target - candidates[i], item, res);
            item.remove(item.size() - 1);
        }

    }
}
