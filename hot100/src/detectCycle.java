public class detectCycle {
    public static void main(String[] args) {

    }

    static class Solution {
        static ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;

            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {// 有环
                    ListNode index1 = fast;
                    ListNode index2 = head;
                    // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                    while (index1 != index2) {
                        index1 = index1.next;
                        index2 = index2.next;
                    }
                    return index1;
                }
            }
            return null;
        }
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }
}
