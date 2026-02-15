public class isPalindrome {
    public static void main(String[] args) {

    }

    static class Solution{
        static boolean isPalindrome(ListNode head){
            // 转为数组后用双指针
            int len = 0;
            ListNode cur = head;
            while(cur != null){
                len ++;
                cur = cur.next;
            }

            int[] list = new int[len];
            cur = head;
            for (int i = 0; i < len; i++) {
                list[i] = cur.val;
                cur = cur.next;
            }

            int left = 0, right = len - 1;
            while(left <= right){
                if(list[left] != list[right]) return false;
                else {
                    left ++;
                    right --;
                }
            }

            return true;
        }
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }
}
