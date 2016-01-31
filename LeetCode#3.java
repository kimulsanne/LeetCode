//LeetCode#3: Longest Substring Without Repeating Characters
//Runtiome: 5ms
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] exist = new int[130];
        int result = 0;
        int max = 0;
        int head = 0, tail = 0;
        int l = s.length();
        while (tail < l) {
            if (exist[s.charAt(tail)] > head) {
                head = exist[s.charAt(tail)];
            }
            tail++;            
            exist[s.charAt(tail - 1)] = tail;
            if (tail - head > max)
                max = tail - head;
        }
        return max;
    }
}