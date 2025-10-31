# 203. 移除链表元素

## 题目特征

- 移除链表元素
- 空间复杂度$O(1)$
- 时间复杂度$O(N)$

## 题目解法

让节点next指针直接指向下下一个节点就可以了

注意：

因为单链表的特殊性，只能指向下一个节点，那么如果删除的是头结点又该怎么办呢？

这里就涉及如下链表操作的两种方式：

- 直接使用原来的链表来进行删除操作。
- 设置一个**虚拟头结点**在进行删除操作。

事实上，linkedlist大部分题目都需要设置虚拟头结点

第一种操作：直接使用原来的链表来进行移除

![removehead1.png](removehead1.png)

只要将头结点向后移动一位就可以，这样就从链表中移除了一个头结点。

![removehead2.png](removehead2.png)

第二种操作：设置一个虚拟头结点

这样原链表的所有节点就都可以按照统一的方式进行移除了。

![dummynode.png](src/dummyNode.png)

最后呢在题目中，return 头结点的时候，别忘了 `return dummyNode->next`;， 这才是新的头结点

## 其他链表题目

### 24. 两两交换链表中的节点

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

使用虚拟头结点，这样会方便很多，要不然每次针对头结点（没有前一个指针指向头结点），还要单独处理。

![img.png](swapPairds1.png)

关于为什么我这么写不对：
```java
public ListNode swapPairs(ListNode head){
    if(head == null || head.next == null){
        return head;
    }

    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;

    ListNode cur = dummyHead;
    ListNode tempFirst = cur.next;
    ListNode tempSecond = tempFirst.next;
    ListNode tempThird = tempSecond.next;

    while(tempThird != null){
        cur.next = tempSecond;
        tempSecond.next = tempFirst;
        tempFirst.next = tempThird;
        cur = tempFirst;
        tempFirst = cur.next;
        tempSecond = tempFirst.next;
        tempThird = tempSecond.next;
    }

    return dummyHead.next;
}
```
1. 空指针异常风险
```java
   while(tempThird != null){
       // ...
       tempFirst = cur.next;        // 可能为null
       tempSecond = tempFirst.next; // 如果tempFirst为null，这里会NPE
       tempThird = tempSecond.next; // 如果tempSecond为null，这里会NPE
   }
```
2. 循环条件不完整

只检查了`tempThird != null`，但没有检查tempFirst和tempSecond是否为null

当链表节点数为偶数时，最后两个节点无法被处理

3. 边界情况处理缺失

对于只有2个节点的链表，循环不会执行（因为tempThird为null）

对于奇数个节点，最后一个节点会被遗漏


### 19. 删除链表的倒数第 N 个结点

双指针的经典应用，如果要删除倒数第n个节点，让`fast`移动`n`步，然后让`fast`和`slow`同时移动，直到`fast`指向链表末尾。删掉`slow`所指向的节点就可以了。

（我觉得这里判断终止条件还挺容易踩坑的）

![img.png](removeNthFromEnd.png)

### 160. 链表相交

找出并返回两个单链表相交的起始节点，不存在环

**解题思路**

1. 求两个链表交点节点的**指针**
2. 注意：交点不是数值相等，而是指针相等，即：
    * `curA == curB`：判断是否是同一个节点对象
    * `curA.val == curB.val`：判断节点值是否相同

时间复杂度：$O(n + m)$

空间复杂度：$O(1)$

### 142. 环形链表Ⅱ

给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

不允许修改链表

**解题思路**

1. 判断链表是否环
2. 如果有环，如何找到这个环的入口

很复杂的一道题，感觉看视频会明白更多：[把环形链表讲清楚！ 如何判断环形链表？如何找到环形链表的入口？ LeetCode：142.环形链表II](https://www.bilibili.com/video/BV1if4y1d7ob/?vd_source=e4161a824a941c59b7a98cc057269115)