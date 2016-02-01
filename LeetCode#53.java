//LeetCode#53: Maximum Subarray
//Runtime: 8ms
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int max = -INT_MAX;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count + nums[i] > 0) {
                count += nums[i];
                if (count > max)
                    max = count;
            }
            else
                count = 0;
            if (max < nums[i])
                max = nums[i];
        }
        return max;
    }
};