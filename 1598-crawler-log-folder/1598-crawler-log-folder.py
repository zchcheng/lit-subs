class Solution:
    def minOperations(self, logs: List[str]) -> int:
        st = 0
        for log in logs:
            if log == './': 
                continue
            elif log == '../':
                st = max(0, st - 1)
            else: st += 1
            
        return st
                
            
            