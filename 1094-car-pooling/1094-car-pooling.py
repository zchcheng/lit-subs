class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        starts = [ (t[1], t[0]) for t in trips ]
        ends = [ (t[2], t[0]) for t in trips ]
        
        starts.sort()
        ends.sort()
        
        current = 0
        j = 0
        
        for s in starts:
            current += s[1]
            
            while ends[j][0] <= s[0]:
                current -= ends[j][1]
                j += 1
                
            if current > capacity:
                return False
            
        return True
            
            