import java.util.*;
public class findAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(Solution.findAnagrams(s, p));
    }

    static class Solution{
        public static List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            if(s.length() < p.length()) return result;

            int[] sCount = new int[26]; // 只包含小写字母
            int[] pCount = new int[26];

            for (int i = 0; i < p.length(); i++) {
                pCount[p.charAt(i) - 'a'] ++;
            }

            int len = p.length();
            int left = 0;
            for (int right = 0; right < s.length(); right++) {
                sCount[s.charAt(right) - 'a'] ++;

                if(left == right - len + 1){
                    if(Arrays.equals(sCount,pCount)){
                        result.add(left);
                    }

                    sCount[s.charAt(left) - 'a'] --;
                    left ++;
                }


            }

            return result;
        }
    }
}
