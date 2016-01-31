//LeetCode#135: Candy
//Runtiome: 36ms
class Solution {
public:
    int candy(vector<int>& ratings) {
        int n = ratings.size();
        int ans = 1, maxcandy = 1,maxpos = 0, now = 1;
        if (n < 1)
            return 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i-1]) {
                if (ratings[i] == ratings[i-1])
                    now = 1;
                else
                    now++;
                maxpos = i;
                maxcandy = now;
                ans += now ;
            }

            else {
                now = 1;
                if (maxcandy <= i - maxpos)
                    ans++;
                ans += i - maxpos + now - 1;
            }
        }
        return ans;
    }
};