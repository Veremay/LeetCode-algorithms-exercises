import java.util.*;

public class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        DLinkedNode(){}
        DLinkedNode(int _key, int _value) {this.key = _key; this.value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部，可以明确界限，这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。
        dummyHead = new DLinkedNode();
        dummyTail = new DLinkedNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            // 如果key不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加到双向链表的头部
            addToHead(newNode);
            size ++;
            if(size > capacity){
                // 超出容量，删除双向链表的尾节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中的对应项
                cache.remove(tail.key);
                size --;
            }
        } else{
            // 如果key存在，修改value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node) {
        dummyHead.next.prev = node;
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next = node;
    }

    private void moveToHead(DLinkedNode node) {
        // 先移除
        removeNode(node);
        // 再添加
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode tail = dummyTail.prev;
        removeNode(tail);
        return tail;
    }
}
