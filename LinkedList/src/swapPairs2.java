import java.util.LinkedList;

public class swapPairs2 {
    public ListNode swapPairs(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = first.next;
            ListNode third = second.next;  // 可能为null

            // 执行交换
            cur.next = second;
            second.next = first;
            first.next = third;

            // 移动cur指针
            cur = first;
        }

        return dummyHead.next;
        }
}
