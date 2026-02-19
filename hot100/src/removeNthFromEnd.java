public class removeNthFromEnd {
    public static void main(String[] args) {

    }

    static class Solution{
        static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode cur = head;
            int len = 0;
            while(cur != null){
                len += 1;
                cur = cur.next;
            }


            return null;
        }
    }
}
