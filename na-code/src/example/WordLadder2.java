package example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * I didn't make this right. So I copied a version online with a little modification to make it clearer which passed
 * leetcode judge.
 * 
 * 
 */
public class WordLadder2 {
    // bfs; need to print all the shortest paths
    public ArrayList<ArrayList<String>> findLadders(final String start, final String end, final HashSet<String> dict) {
        final ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (start == null || end == null) {
            return res;
        }
        final ArrayList<String> tmparray = new ArrayList<String>();

        // 如果start与end相等，直接返回
        if (start.equals(end)) {
            tmparray.add(start);
            tmparray.add(end);
            res.add(tmparray);
            return res;
        }

        // 新建一个hashmap，保存每个节点的所有前驱。
        final HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        map.put(end, new ArrayList<String>());
        map.put(start, new ArrayList<String>());
        for (final String s : dict) {
            map.put(s, new ArrayList<String>());
        }

        // 利用bfs 层序遍历 如果队列中有end 那么结束遍历（到最短的一层就结束）
        final Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        final ArrayList<String> currentlevel = new ArrayList<String>();
        while (!queue.isEmpty()) {
            // number of words in one level
            final int level = queue.size();
            currentlevel.clear();
            for (int i = 0; i < level; i++) {
                final String top = queue.poll();
                if (dict.contains(top)) {
                    dict.remove(top);
                }
                currentlevel.add(top);
            }

            // 循环每个String的每个char 从a到z，在dict里面找是否有
            for (final String curs : currentlevel) {
                for (int i = 0; i < curs.length(); ++i) {
                    for (char j = 'a'; j <= 'z'; ++j) {
                        if (j == curs.charAt(i)) {
                            continue;
                        }
                        final char[] tmpchar = curs.toCharArray();
                        tmpchar[i] = j;
                        final String tmps = new String(tmpchar);
                        if (tmps.equals(end)) {
                            map.get(end).add(curs);
                            queue.offer(tmps);
                        }
                        else if (dict.contains(tmps)) {
                            // no repeat nodes
                            if (!queue.contains(tmps)) {
                                queue.offer(tmps);
                            }
                            map.get(tmps).add(curs);
                        }
                    }
                }
            }
            if (queue.contains(end)) {
                break;
            }
        }
        tmparray.add(end);
        buildpath(start, end, map, tmparray, res);
        return res;
    }

    // 根据节点的前驱 生成路径
    public void buildpath(final String start, final String end, final HashMap<String, ArrayList<String>> map, final ArrayList<String> tmparray, final ArrayList<ArrayList<String>> res) {
        // tracing back from the end word, because start word doesn't have a prev
        final ArrayList<String> pre = map.get(end);
        if (end.equals(start)) {
            final ArrayList<String> tmparray2 = new ArrayList<String>(tmparray);
            Collections.reverse(tmparray2);
            res.add(tmparray2);
            // return;
        }
        for (final String s : pre) {
            tmparray.add(s);
            buildpath(start, s, map, tmparray, res);
            // clear elements in the list; so that next time there will be the next group of words
            tmparray.remove(tmparray.size() - 1);
        }

    }

}