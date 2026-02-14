import java.util.*;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(Solution.lengthOfLongestSubstring(s));
    }

    static class Solution{
        static int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int result = 0;
            int left = 0;
            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                map.put(c, map.getOrDefault(c, 0) + 1);
                while(map.get(c) > 1){
                    char leftChar = s.charAt(left);
                    map.put(leftChar, map.get(leftChar) - 1);
                    left++;
                }

                // 这个时候无重复子串了
                result = Math.max(result, right - left + 1);
            }
            return result;
        }
    }
}
