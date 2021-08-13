package cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 缓存机制
 *
 * @author YangKai
 */
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 105 
// 最多调用 2 * 105 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 1552 👎 0


public class LruCache {
    public static void main(String[] args) {
        LruCache lruCache = new LruCache();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 最近最少使用缓存 LinkedHashMap中accessOrder=true按访问顺序排序
     */
    class LRUCacheHash extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCacheHash(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }


    /**
     * 使用hash + 双向链表，key = key， value = node
     */
    class LRUCache {

        /**
         * 双向链表
         */
        class LinkedNode {
            int key;
            int value;
            LinkedNode prev;
            LinkedNode next;

            public LinkedNode() {
            }

            public LinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity;
        // 链表长度
        private int size;
        // 头节点
        private LinkedNode head;
        // 尾节点
        private LinkedNode tail;
        // 缓存结构
        Map<Integer, LinkedNode> cache = new HashMap<>(capacity);

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 使用伪头部节点和伪尾部节点
            head = new LinkedNode();
            tail = new LinkedNode();
            // 关联节点
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            LinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 存在则将当前节点移至头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            LinkedNode node = cache.get(key);
            if (node == null) {
                // 不存在则添加新节点
                LinkedNode newNode = new LinkedNode(key, value);
                cache.put(key, newNode);
                // 添加至头部
                addToHead(newNode);
                size++;
                if (size > capacity) {
                    LinkedNode rmNode = removeTail();
                    cache.remove(rmNode.key);
                    size--;
                }
            } else {
                // 存在更新值，并插至头部
                node.value = value;
                moveToHead(node);
            }

            cache.put(key, node);
        }

        /**
         * 伪尾部节点下一节点去掉
         */
        private LinkedNode removeTail() {
            LinkedNode rmNode = tail.prev;
            removeNode(rmNode);
            return rmNode;
        }

        /**
         * 移动至头部
         *
         * @param node
         */
        private void moveToHead(LinkedNode node) {
            // 删除当前节点
            removeNode(node);
            // 添加至头部
            addToHead(node);
        }

        private void removeNode(LinkedNode node) {
            // 当前节点的前节点的下一节点指向当前节点的下一节点
            node.prev.next = node.next;
            // 当前节点的下一节点的前节点指向当前节点的前节点
            node.next.prev = node.prev;
        }

        /**
         * 除去伪头部节点
         *
         * @param node
         */
        private void addToHead(LinkedNode node) {
            // 头结点的前节点为当前节点
            head.prev = node;
            // 当前节点的下一节点为头结点的下一节点【伪头部节点】
            node.next = head.next;
            // 除去伪头部节点，头部节点为当前节点
            head.next.prev = node;
            // 伪头部节点下一节点为当前节点
            head.next = node;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}