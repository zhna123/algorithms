package example;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate
 * numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 * 
 * "loop and recursion"
 * 
 */
public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(final int[] candidates, final int target) {

        final ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), res);

        return res;

    }

    /**
     * 
     * @param candidates
     * @param start
     *            start from first element in candidates
     * @param target
     * @param item
     *            save each combination
     * @param res
     *            result set(add each item in)
     */
    private void helper(final int[] candidates, final int start, final int target, final ArrayList<Integer> item, final ArrayList<ArrayList<Integer>> res) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            // add one combination
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // check repeated elements
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            item.add(candidates[i]);
            // recursion(dfs)
            // i won't increase 1 here is because we can choose same number repeatedly
            helper(candidates, i, target - candidates[i], item, res);
            // remove the last element when poping out of recursion
            // so that item will be used for the next loop
            // or if we can't find the combination, we need to remove those elements
            item.remove(item.size() - 1);
        }
    }

}
