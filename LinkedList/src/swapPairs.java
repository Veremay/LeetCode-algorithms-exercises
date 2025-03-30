public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        ListNode temp; // 临时节点，保存两个节点后面的节点
        ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstnode = cur.next;
            // secondnode = cur.next.next;

            //cur.next = secondnode; // 步骤一
            cur.next = cur.next.next;
            // secondnode.next = firstnode; // 步骤二
            cur.next.next = firstnode;
            firstnode.next = temp; // 步骤三

            cur = cur.next.next;

        }

        return dummyHead.next; // return链表真正的头节点
    }


}
