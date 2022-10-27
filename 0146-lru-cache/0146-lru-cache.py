class LRUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.head = Node(-1, -1)
        self.tail = Node(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.map = {}
        

    def get(self, key: int) -> int:
        if key not in self.map:
            return -1
        
        n = self.map.get(key)
        self.update(key)
        return n.v
        

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            n = self.map.get(key)
            n.v = value
            self.update(key)
        else:
            self.add(key, value)
            if len(self.map) > self.cap:
                self.remove(self.head.next.k)
        
    
    def remove(self, key: int):
        n = self.map.get(key)
        if not n:
            return None
        n.prev.next = n.next
        n.next.prev = n.prev
        self.map.pop(key)
        return n
        
        
    def add(self, key: int, val: int) -> None:
        n = Node(key, val)
        n.next = self.tail
        n.prev = self.tail.prev
        self.tail.prev.next = n
        self.tail.prev = n
        self.map[key] = n
        
        
    def update(self, key: int) -> None:
        n = self.remove(key)
        self.add(key, n.v)

class Node:
    def __init__(self, k, v):
        self.k = k
        self.v = v
        self.next = None
        self.prev = None
        


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)