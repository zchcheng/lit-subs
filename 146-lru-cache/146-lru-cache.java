class LRUCache {
    LinkedListNode head = null;
    LinkedListNode tail = null;
    Map<Integer, LinkedListNode> map = new HashMap<>();
    int size;
    
    public LRUCache(int capacity) {
        size = capacity;
        
        // create dummy
        head = new LinkedListNode(-1, -1);
        tail = head;
    }
    
    public int get(int key) {
        LinkedListNode lln = map.get(key);
        if (lln == null) return -1;
        
        renewNode(lln);
        
        return lln.value;
    }
    
    public void put(int key, int value) {
        LinkedListNode lln = map.get(key);
        
        if (lln == null) {
            lln = new LinkedListNode(key, value);
            map.put(key, lln);
            appendNode(lln);
        } else {
            lln.value = value;
            renewNode(lln);
        }
        
        if (map.size() > size) {
            LinkedListNode remove = removeHead();
            if (remove != null) map.remove(remove.key);
        }
    }
    
    void renewNode(LinkedListNode lln) {
        if (lln == tail) return;
        
        lln.prev.next = lln.next;
        
        if (lln.next != null) lln.next.prev = lln.prev;
        
        appendNode(lln);
    }
    
    LinkedListNode removeHead() {
        if (head.next == null) return null;
        
        LinkedListNode remove = head.next;
        
        head.next = remove.next;
        if (remove.next.prev != null) remove.next.prev = head;
        
        return remove;
    }
    
    void appendNode(LinkedListNode lln) {
        if (tail == lln) return;
        
        tail.next = lln;
        lln.prev = tail;
        tail = lln;
        tail.next = null;
    }
    
    class LinkedListNode {
        public int key;
        public int value;
        
        public LinkedListNode prev = null;
        public LinkedListNode next = null;

        public LinkedListNode(int key, int value) {
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