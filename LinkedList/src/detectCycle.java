public class detectCycle {
    public ListNode detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        // 快指针一次走两步
        // 慢指针一次走一步
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            // 确定相遇的地方，把相遇的地方定为一个指针的新的起点，另一个指针新的起点是head
            if(fast == slow){
                ListNode cur1 = fast;
                ListNode cur2 = head;
                while( cur1 != cur2 ){
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                }
                return cur1;

            }
        }

        return null;
    }
}
