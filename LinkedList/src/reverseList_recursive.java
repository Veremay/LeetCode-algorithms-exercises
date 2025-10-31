import java.util.List;

public class reverseList_recursive {
    public ListNode reverseList(ListNode head){
        // 方法二 递归法
        // 其实思路和双指针法是一样的
        // 空间复杂度
        // 时间复杂度
        if (head == null){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        return reverse(pre, cur);
    }

    public ListNode reverse(ListNode pre, ListNode cur){
        ListNode temp = cur.next;
        cur.next = pre;
        temp.next = cur;
        pre = cur;
        cur = temp;
        return reverse(pre, cur);
    }
}
