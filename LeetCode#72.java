//LeetCode#72: Edit Distance
//Runtime: 16ms
class Solution {
public:
    int minDistance(string word1, string word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int f[l1 + 1][l2 + 1];
        for (int i = 0; i < l1 + 1; i++)
            f[i][0] = i;
        for (int i = 0; i < l2 + 1; i++)
            f[0][i] = i;
        for (int i = 1; i < l1 + 1; i++)
            for (int j = 1; j < l2 + 1; j++) {
                if (word1[i - 1] == word2[j - 1])
                    f[i][j] = minOfThree(f[i][j-1] + 1, f[i-1][j-1], f[i-1][j] + 1);   
                else
                    f[i][j] = minOfThree(f[i][j-1] + 1, f[i-1][j-1] + 1, f[i-1][j] + 1); 
            }
        return f[l1][l2];
    }

    int minOfThree(int x, int y, int z) {
        if (x > y)
            return y>z?z:y;
        else
            return x>z?z:x;
    }
};