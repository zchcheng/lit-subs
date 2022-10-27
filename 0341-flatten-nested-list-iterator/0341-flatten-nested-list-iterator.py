# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger:
#    def isInteger(self) -> bool:
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        """
#
#    def getInteger(self) -> int:
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        """
#
#    def getList(self) -> [NestedInteger]:
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        """

class NestedIterator:
    def __init__(self, nestedList: [NestedInteger]):
        self.currentList = nestedList
        self.currentIndex = -1
        self.stack = []
        self.getNext()
    
    def next(self) -> int:
        v = self.currentList[self.currentIndex].getInteger()
        self.getNext()
        return v
    
    def hasNext(self) -> bool:
        return self.currentList
        
    def getNext(self) -> None:
        while self.currentList is not None:
            self.currentIndex += 1
            
            if self.currentIndex >= len(self.currentList):
                self.currentList = None
                if self.stack:
                    self.currentIndex, self.currentList = self.stack.pop()
                
            elif not self.currentList[self.currentIndex].isInteger():
                self.stack.append((self.currentIndex, self.currentList))
                self.currentList = self.currentList[self.currentIndex].getList()
                self.currentIndex = -1
            else:
                return
                
            
            
                    
            
            
            
        
         

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())