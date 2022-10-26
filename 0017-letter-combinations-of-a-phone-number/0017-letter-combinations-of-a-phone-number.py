class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return []
        
        res = ['']
        
        km = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }
        
        for d in digits:
            ks = km.get(d, '')
            
            for _ in range(len(res)):
                c = res.pop(0)
                
                for k in ks:
                    res.append(c + k)
                    
        return res
            
        
        