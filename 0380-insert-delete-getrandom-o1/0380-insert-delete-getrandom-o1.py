class RandomizedSet:
    

    def __init__(self):
        self.itemList = []
        self.dict = {}
        

    def insert(self, val: int) -> bool:
        if val in self.dict:
            return False
        self.itemList.append(val)
        self.dict[val] = len(self.itemList) - 1
        return True

    def remove(self, val: int) -> bool:
        if val not in self.dict:
            return False
        
        idx = self.dict[val]
        if idx != len(self.itemList) - 1:
            self.itemList[idx], self.itemList[-1] = self.itemList[-1], self.itemList[idx]
            self.dict[self.itemList[idx]] = idx
            
        self.itemList.pop()
        self.dict.pop(val)
        
        return True

    def getRandom(self) -> int:
        return self.itemList[random.randint(0, len(self.itemList) - 1)]
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()