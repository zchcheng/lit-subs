class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        a1 = None
        cnt1 = 0
        a2 = None
        cnt2 = 0
        
        for n in nums:
            if a1 == n:
                cnt1 += 1
            elif a2 == n:
                cnt2 += 1
            elif cnt1 == 0:
                a1 = n
                cnt1 = 1
            elif cnt2 == 0:
                a2 = n
                cnt2 = 1
            else:
                cnt1 -= 1
                cnt2 -= 1
                    
        res = []
        
        if nums.count(a1) > len(nums) // 3:
            res.append(a1)
            
        if nums.count(a2) > len(nums) // 3:
            res.append(a2)
            
        return res
                