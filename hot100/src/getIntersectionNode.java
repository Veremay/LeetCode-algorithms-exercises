public class getIntersectionNode {
    public static ListNode[] buildIntersectingLists(int[] listA, int[] listB, int skipA, int skipB) {
        // 先构建公共部分：从skipA位置开始到listA末尾
        ListNode commonHead = null;
        ListNode commonTail = null;
        for (int i = skipA; i < listA.length; i++) {
            ListNode newNode = new ListNode(listA[i]);
            if (commonHead == null) {
                commonHead = newNode;
                commonTail = newNode;
            } else {
                commonTail.next = newNode;
                commonTail = newNode;
            }
        }

        // 构建链表A：前skipA个节点 + 公共部分
        ListNode headA = null;
        ListNode tailA = null;
        for (int i = 0; i < skipA; i++) {
            ListNode newNode = new ListNode(listA[i]);
            if (headA == null) {
                headA = newNode;
                tailA = newNode;
            } else {
                tailA.next = newNode;
                tailA = newNode;
            }
        }
        if (tailA != null) {
            tailA.next = commonHead; // 链接公共部分
        } else {
            headA = commonHead; // 如果skipA为0，则直接以公共部分为头
        }

        // 构建链表B：前skipB个节点 + 公共部分
        ListNode headB = null;
        ListNode tailB = null;
        for (int i = 0; i < skipB; i++) {
            ListNode newNode = new ListNode(listB[i]);
            if (headB == null) {
                headB = newNode;
                tailB = newNode;
            } else {
                tailB.next = newNode;
                tailB = newNode;
            }
        }
        if (tailB != null) {
            tailB.next = commonHead;
        } else {
            headB = commonHead;
        }

        return new ListNode[]{headA, headB};
    }



    public static void main(String[] args) {
        int[] listA = {4,1,8,4,5};
        int[] listB = {5,6,1,8,4,5};
        int skipA = 2, skipB = 3;
        ListNode[] heads = buildIntersectingLists(listA, listB, skipA, skipB);
        ListNode headA = heads[0];
        ListNode headB = heads[1];
        System.out.println(Solution.getIntersectionNode(headA, headB).val);
    }

    static class Solution{
        public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
            // 把两个链表尾部对齐
            int lenA = 0, lenB = 0;
            ListNode curA = headA;
            ListNode curB = headB;
            while(curA != null){
                lenA++;
                curA = curA.next;
            }
            while(curB != null){
                lenB++;
                curB = curB.next;
            }

            curA = headA;
            curB = headB;
            int gap = 0;
            if(lenA > lenB){
                gap = lenA - lenB;
                for (int i = 0; i < gap; i++) {
                    curA = curA.next;
                }
            }else{
                gap = lenB- lenA;
                for (int i = 0; i < gap; i++) {
                    curB = curB.next;
                }
            }

            // 开始遍历
            while(curA != null && curB != null){
                if(curA == curB){
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }

            return null;
        }
    }

    private ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
      }
    }
}
