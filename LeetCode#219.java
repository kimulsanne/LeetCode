//LeetCode#219: Contains Duplicate II
//Runtime: 13ms
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (numbers.containsKey(nums[i]) && (i - numbers.get(nums[i]) <= k) )
                return true;
            else
                numbers.put(nums[i], i);
        }
        return false;
    }
}