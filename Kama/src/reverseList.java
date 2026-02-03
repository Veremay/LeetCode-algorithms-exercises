import java.util.*;

public class reverseList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            if(n == 0){
                System.out.println("list is empty");
                continue;
            }
            ListNode dummyHead = new ListNode();
            ListNode cur = dummyHead;
            for (int i = 0; i < n; i++) {
                ListNode node = new ListNode(sc.nextInt());
                cur.next = node;
                cur = node;
            }

            printList(dummyHead);
            printList(new Solution().reverseList(dummyHead));
        }
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
    }

    static void printList(ListNode head){
        ListNode cur = head.next;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    static class Solution{
        static ListNode reverseList(ListNode head){
            ListNode cur = head.next;
            ListNode pre = null;
            while(cur != null){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            head.next = pre;

            return head;
        }
    }
}


