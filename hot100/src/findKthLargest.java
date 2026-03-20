import java.util.PriorityQueue;

public class findKthLargest {
    public static void findKthLargest(String[] args){

    }

    static class Solution{
        private static int findKthLargest(int[] nums, int k) {
            // 1. 初始化一个小顶堆，限制大小为 k
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

            for (int i = 0; i < nums.length; i++) {
                // 如果堆还没满，直接加进去
                if (minHeap.size() < k) {
                    minHeap.offer(nums[i]);
                }
                // 如果堆满了，且当前数字比堆顶（最小值）大
                else if (nums[i] > minHeap.peek()) {
                    minHeap.poll();  // 踢走最小的那个
                    minHeap.offer(nums[i]); // 换更强的进来
                }
            }

            // 3. 遍历结束后，堆顶就是第 k 个最大的元素
            return minHeap.peek();
        }
    }
}
