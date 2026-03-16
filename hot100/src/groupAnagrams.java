import java.util.*;

public class groupAnagrams {
    public static void main(String[] args) {

    }

    static class Solution {
        public static List<List<String>> groupAnagrams(String[] strs) {
            // 把数组当作key 错误！！
            // 数组（如 int[]）是对象，它们继承自 Object 的 hashCode() 和 equals() 方法。Object 的这两个方法默认比较的是对象的引用（内存地址），而不是数组的内容。
            // Map<int[], List<String>> map = new HashMap<>();
            // 优化：将单词的字符排序后作为键

            Map<String, List<String>> map = new HashMap<>();

            for(String str: strs){
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);

                List<String> list = map.getOrDefault(key,new ArrayList<>());
                if(list.isEmpty()){
                    list.add(str);
                    map.put(key, list);
                }else{
                    list.add(str);
                }
            }

            List<List<String>> result = new ArrayList<>();
            for(List<String> mapList: map.values()){
                result.add(mapList);
            }

            return result;
        }
    }
}
