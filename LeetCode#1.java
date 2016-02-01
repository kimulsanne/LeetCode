//LeetCode#1: Two Sum
//Runtime: 6ms
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (numMap.containsKey(target - nums[i])) {
                result[1] = i + 1;
                result[0] = numMap.get(target - nums[i]) + 1;
                return result;
            }
            else {
        		numMap.put(nums[i], i);
        	}
        }    
        return result;
    }
}