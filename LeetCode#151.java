//LeetCode#151: Reverse Words in a String
//Runtime: 4ms
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) {
            words[i].trim();
            if (!words[i].equals(""))
                result.append(words[i] + " ");
        }
        result.append(words[0].trim());
        return result.toString();
    }
}