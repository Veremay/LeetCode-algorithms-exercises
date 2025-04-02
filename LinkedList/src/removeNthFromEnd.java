public class removeNthFromEnd {
    static public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode fast = dummyHead;
        ListNode slow = dummyHead; //指向要被删除的结点


        while (n != 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        ListNode temp = slow; //记录要被删除的结点的上一个
        while (fast != null) {
            fast = fast.next;
            temp = slow;
            slow = slow.next;
        }

        temp.next = slow.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        // 构建测试链表 [1,2,6,3,4,5,6]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        // 移除值为6的节点
        ListNode newHead = removeNthFromEnd(head, 7);

        // 打印修改后的链表
        printList(newHead);

    }

    // 辅助方法：打印链表
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

}
