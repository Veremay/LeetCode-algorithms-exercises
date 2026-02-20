public class swapPairs {
    public static void main(String[] args) {

    }

    static class Solution{
        static ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode cur = head;
            ListNode pre = dummyHead;
            while(cur != null && cur.next != null){
                ListNode next = cur.next.next;
                pre.next = cur.next;
                cur.next.next = cur;
                cur.next = next;
                pre = cur;
                cur = next;
            }

            return dummyHead.next;
        }
    }
}
