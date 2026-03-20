import java.util.*;

public class topKFrequent {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] res = Solution.topKFrequent(nums, k);
        for (int num: res){
            System.out.print(num + ",");
        }
    }

    static class Solution{
        public static int[] topKFrequent(int[] nums, int k){
            // 先计算频率
            Map<Integer, Integer> map = new HashMap<>();
            for (int num: nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // 再创建小顶堆
            // 需要告诉 PriorityQueue 比较的是频率（Map 的 Value），而不是数字本身：
            // a 和 b 是数组里的数字，我们根据它们在 map 中的频率来比较
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                    (a, b) -> map.get(a) - map.get(b)
            );

            for (int key : map.keySet()){
                if( minHeap.size() < k){
                    minHeap.add(key);
                }else{
                    if(map.get(key) > map.get(minHeap.peek())){
                        minHeap.poll();
                        minHeap.add(key);
                    }
                }
            }

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = minHeap.poll();
            }

            return result;
        }
    }
}
