//LeetCode#164: Maximum Gap
//Runtiome: 12ms
class Solution {
public:
    int maximumGap(vector<int>& nums) {
        int n = nums.size();
        if (n < 2)
            return 0;
        int maxn = *max_element(nums.begin(), nums.end());
        int exp = 1;
        int radix = 10;
        int *aux = (int *)malloc(sizeof(int) * n);
        while (maxn / exp > 0) {
            int *count = (int *)malloc(sizeof(int) * radix);
            memset(count, 0, sizeof(int) * radix);
            for (int i = 0; i < n; i++) {
                count[(nums[i] / exp) % 10]++;
            }
            for (int i = 1; i < radix; i++) {
                count[i] += count[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                aux[--count[(nums[i] / exp) % 10]] = nums[i];
             }

            for (int i = 0; i < n; i++) {
                nums[i] = aux[i];
            }
            exp *= 10;
        }
        int maxdiff = 0;
        for (int i = 0; i < n - 1; i++) 
            if (abs(aux[i + 1] - aux[i]) > maxdiff)
                maxdiff = abs(aux[i + 1] - aux[i]);

        return maxdiff;
    }
};