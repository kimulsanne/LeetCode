//LeetCode#264: Ugly Number II
//Runtiome: 12ms
class Solution {
public:
    int minOfThree(int a, int b, int c) {
        if (a < b)
            return a < c ? a : c;
        return b < c ? b : c;
    }
    
    int nthUglyNumber(int n) {
        if (n == 1)
        return 1;
        vector<int> queue(n,0);
        queue[0] = 1;
        int index_2 = 0, index_3 = 0, index_5 = 0;
        int f2 = 2, f3 = 3, f5 = 5;
        for (int i = 1; i < n; ++i) {
            int min = minOfThree(f2, f3, f5);
            queue[i] = min;
            if (min == f2) 
                f2 = 2 * queue[++index_2];
            if (min == f3) 
                f3 = 3 * queue[++index_3];
            if (min == f5) 
                f5 = 5 * queue[++index_5];
        }
        return queue[n-1];
    }
    
   
};