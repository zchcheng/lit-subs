class LRUCache {
    // Cap: 3
    // Map: 5: 11, 7: 4, 8: 2
    // DLL: 7 -> 5 -> 8
    
    int cap = -1;
    Map<Integer, DDLNode> map = new HashMap<>();
    DDLNode head = new DDLNode(-1, -1);
    DDLNode tail = new DDLNode(-1, -1);

    public LRUCache(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DDLNode node = map.get(key);
            update(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DDLNode node = map.get(key);
            node.value = value;
            update(node);
        } else {
            DDLNode node = new DDLNode(key, value);
            add(node);
            
            while(map.size() > cap) {
                remove(head.next);
            }
        }
    }
    
    void remove(DDLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }
    
    void add(DDLNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        map.put(node.key, node);
    }
    
    void update(DDLNode node) {
        remove(node);
        add(node);
    }
    
        
    void print() {
        DDLNode current = head.next;
        System.out.print("List: ");
        while(current != null) {
            System.out.print("[" + current.key + ", " + current.value + "] ");
            current = current.next;
        }
        System.out.println();
    }
    
    class DDLNode {
        public int key;
        public int value;
        public DDLNode prev;
        public DDLNode next;
        
        public DDLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */