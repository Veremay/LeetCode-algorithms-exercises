import java.util.*;

public class deleteDuplicate{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int n = sc.nextInt();
            if(n == 0){
                System.out.println("list is empty");
                continue;
            }
            Node dummyHead = new Node();
            Node cur = dummyHead;
            for (int i = 0; i < n; i++) {
                Node node = new Node(sc.nextInt());
                cur.next = node;
                cur = node;
            }

            printList(dummyHead);
            printList(new Solution().deleteDuplicate(dummyHead));

        }
    }

    static void printList(Node head){
        Node cur = head.next;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    static class Solution{
        static Node deleteDuplicate(Node head){
            Node cur = head;
            while(cur != null){
                Node temp = cur.next;
                while(temp != null && cur.val == temp.val){
                    temp = temp.next;
                }
                cur.next = temp;
                cur = temp;
            }
            return head;
        }

    }

    static class Node{
        int val;
        Node next;
        Node(){}
        Node(int val){
            this.val = val;
        }
    }
}





