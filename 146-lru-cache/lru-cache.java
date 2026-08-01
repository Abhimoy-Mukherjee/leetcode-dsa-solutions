class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key , int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    HashMap<Integer,Node> map;
    Node dummyHead;
    Node dummyTail;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        dummyHead = new Node(-1,-1);
        dummyTail = new Node(-1,-1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node temp = map.get(key);
        removeNode(temp);
        insertFront(temp);
        return temp.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node temp = map.get(key);
            temp.value = value;
            removeNode(temp);
            insertFront(temp);
            return ;
        }
        if(map.size() == capacity)
        {
            Node lru = dummyTail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }
        Node temp = new Node(key, value);
        map.put(key, temp);
        insertFront(temp);

    }
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insertFront(Node node){
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */