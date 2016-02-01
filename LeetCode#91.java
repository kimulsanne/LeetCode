//LeetCode#91: Decode Ways
//Runtime: 1ms
public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int first = 1, second = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                 if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7')) {
                    second = first + second;
                    first = second - first;
                 }
                 else {
                     first = second;
                 }
            }
            else if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                return 0;
            }
            else {
                second = first;
            }
        }
        return second;
    }
}