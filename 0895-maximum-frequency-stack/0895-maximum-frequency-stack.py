class FreqStack:

    def __init__(self):
        self.max_freq = 0
        self.cnt_map = defaultdict(lambda: 0)
        self.freq_map = defaultdict(lambda: [])

    def push(self, val: int) -> None:
        self.cnt_map[val] += 1
        self.freq_map[self.cnt_map[val]].append(val)
        self.max_freq = max(self.max_freq, self.cnt_map[val])
        

    def pop(self) -> int:
        stack = self.freq_map[self.max_freq]
        res = stack.pop()
        self.cnt_map[res] -= 1
        
        if not stack:
            self.max_freq -= 1
            
        return res
        

# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()