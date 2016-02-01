//LeetCode#1: Pascal's Triangle
//Runtime: 1ms
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> now = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i || i == 0)
                    now.add(1);
                else
                    now.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
             }
            result.add(now);   
        }
        return result;
    }
}