public class mergeTwoLists {
    public static void main(String[] args) {

    }

    static class Solution{
        static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode pre = dummyHead;

            ListNode cur1 = list1;
            ListNode cur2 = list2;
            while(cur1 != null && cur2 != null){
                if(cur1.val < cur2.val){
                    pre.next = cur1;
                    cur1 = cur1.next;
                }else{
                    pre.next = cur2;
                    cur2 = cur2.next;
                }
                pre = pre.next;
            }

            // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
            pre.next = cur1 == null ? cur2 : cur1;

            return dummyHead.next;
        }
    }

}
