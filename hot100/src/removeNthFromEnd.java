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

            // 如果要删除的是头节点
            if (n == len) {
                return head.next;
            }

            int count = 0;
            cur = head;
            while(count < len - n - 1){
                cur = cur.next;
                count ++;
            }

            if(cur.next.next != null){
                cur.next = cur.next.next;
            }else{
                cur.next = null;
            }

            return head;
        }
    }
}
