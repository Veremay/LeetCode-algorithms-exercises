public class sortList {
    public static void main(String[] args) {

    }

    static class Solution{
        static ListNode sortList(ListNode head) {
            if(head == null) return head;
            // 得到总长度
            int len = 0;
            ListNode cur = head;
            while(cur != null){
                len ++;
                cur = cur.next;
            }

            ListNode dummyHead = new ListNode(-1, head);
            // 从1开始，每次翻倍，直到覆盖整个链表
            for (int subLen = 1; subLen < len; subLen *= 2) {
                // prev：指向已排序部分的最后一个节点，用于连接合并后的链表
                // cur：当前要处理的第一个节点
                ListNode prev = dummyHead;
                cur = dummyHead.next;
                // 每次处理两个长度为subLen的链表
                while(cur != null){
                    // 找到第一个子链表
                    ListNode head1 = cur;
                    // 从 cur 开始走 subLength-1 步，定位到第一个子链表的尾节点
                    for (int i = 1; i < subLen && cur.next != null; i++) {
                        cur = cur.next;
                    }

                    // 找到第二个子链表 head2，并断开第一个子链表
                    ListNode head2 = cur.next; // 第二个子链表的头节点
                    cur.next = null;           // 断开第一个子链表与后面的连接
                    cur = head2;

                    // 定位第二个子链表的尾节点（注意边界：可能不足 subLen 且不能越界）
                    for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                        cur = cur.next;
                    }

                    // 保存下一对待处理链表的起始位置
                    ListNode next = null;
                    if (cur != null) { // 判断一下，如果刚好全部分完，cur = null
                        next = cur.next; // 下一对的起始节点
                        cur.next = null; // 断开第二个子链表
                    }

                    // 合并两个链表 head1 和 head2
                    ListNode merged = merge(head1, head2);
                    prev.next = merged; // 连接

                    // 将 prev 移动到合并后链表的末尾，以便连接下一次合并的结果
                    while (prev.next != null) {
                        prev = prev.next;
                    }

                    // 将 cur 移动到下一对待处理链表的起始位置，继续循环
                    cur = next;
                }
            }

            return dummyHead.next;
        }

        /**
         * 合并两个有序链表（经典双指针法）
         */
        static ListNode merge(ListNode head1, ListNode head2){
            ListNode dummyHead = new ListNode(-1);
            ListNode prev = dummyHead, cur1 = head1, cur2 = head2;
            while(cur1 != null && cur2 != null){
                if(cur1.val < cur2.val){
                    prev.next = cur1;
                    cur1 = cur1.next;
                }else{
                    prev.next = cur2;
                    cur2 = cur2.next;
                }
                prev = prev.next;
            }

            // 连接剩余部分
            if(cur1 != null){
                prev.next = cur1;
            }
            else if(cur2 != null){
                prev.next = cur2;
            }

            return dummyHead.next;
        }
    }
}
