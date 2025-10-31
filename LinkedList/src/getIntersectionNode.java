public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        // 统计链表A的长度
        int lenA = 0;
        ListNode curA = headA;
        while(curA != null){
            lenA++;
            curA = curA.next;
        }
        // 统计链表B的长度
        int lenB = 0;
        ListNode curB = headB;
        while(curB != null){
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        // 把curA设为较长的那条链表的头, lenA是它的长度
        if(lenB > lenA){
            ListNode tempHead = curB;
            curB = curA;
            curA = tempHead;

            int tempLen = lenB;
            lenB = lenA;
            lenA = tempLen;
        }

        // 计算两条链表差了多少
        int gap = lenA - lenB;

        // 把curA往前挪动到gap + 1
        for (int i = 0; i < gap; i++) {
            curA = curA.next;
        }

        // 开始同时挪动curA和curB
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
