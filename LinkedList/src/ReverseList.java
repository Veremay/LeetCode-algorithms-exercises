public class ReverseList {
    public ListNode reverseList(ListNode head) {
        // 方法一 双指针
        // 时间复杂度O(N)
        // 空间复杂度O(1)
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;// return新的头节点
    }
}
