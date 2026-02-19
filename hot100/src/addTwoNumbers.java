public class addTwoNumbers {
    public static void main(String[] args) {

    }

    static class Solution{
        static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            ListNode head = new ListNode(-1);
            ListNode cur = head;
            int pre = 0;
            while(cur1 != null || cur2 != null){
                int cur1Val = cur1 != null ? cur1.val : 0;
                int cur2Val = cur2 != null ? cur2.val : 0;

                int sum = cur1Val + cur2Val + pre;
                ListNode node = new ListNode(sum % 10);
                pre = sum / 10;

                cur.next = node;
                cur = node;

                if(cur1 != null) cur1 = cur1.next;
                if(cur2 != null) cur2 = cur2.next;

            }

            if(pre > 0){
                cur.next = new ListNode(pre);
            }

            return head.next;
        }
    }
}
