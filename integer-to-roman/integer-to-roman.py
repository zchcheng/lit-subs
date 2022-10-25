class Solution:
    def intToRoman(self, num: int) -> str:
        map = [
            ('I', 1),
            ('IV', 4),
            ('V', 5),
            ('IX', 9),
            ('X', 10),
            ('XL', 40),
            ('L', 50),
            ('XC', 90),
            ('C', 100),
            ('CD', 400),
            ('D', 500),
            ('CM', 900),
            ('M', 1000)
        ]
        
        
        p = len(map) - 1
        res = ''
        
        while num:
            while map[p][1] > num:
                p -= 1
            res += map[p][0]
            num -= map[p][1]
            
        return res