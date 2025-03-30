/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class MyLinkedList {
    class ListNode {
        // 结点的值
        int val;

        // 下一个结点
        ListNode next;

        // 节点的构造函数(无参)
        public ListNode() {
        }

        // 节点的构造函数(有一个参数)
        public ListNode(int val) {
            this.val = val;
        }
    }

    private int size;
    private ListNode head; //注意这是一个虚拟头节点

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    // 获取到第index个节点数值，如果index是非法数值直接返回-1， 注意index是从0开始的，第0个节点就是头结点
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode cur = head;
        //第0个节点是虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        // 在链表最前面插入一个节点，等价于在第0个元素前添加
        // addAtIndex(0, val);
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        // 在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
        // addAtIndex(size, val);
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        //找到要插入节点的前驱
        ListNode prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index){
        if (index < 0 || index >= size) {
            return;
        }

        //因为有虚拟头节点，所以不用对index=0的情况进行特殊处理
        ListNode prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        size--;
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

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addAtHead(1);
        // 打印修改后的链表
        printList(myLinkedList.head);

        myLinkedList.addAtTail(3);
        // 打印修改后的链表
        printList(myLinkedList.head);

        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        // 打印修改后的链表
        printList(myLinkedList.head);

        myLinkedList.get(1);              // 返回 2

        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        // 打印修改后的链表
        printList(myLinkedList.head);

        myLinkedList.get(1);              // 返回 3
    }

}
