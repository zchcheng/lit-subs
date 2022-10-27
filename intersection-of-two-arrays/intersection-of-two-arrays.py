class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        s1 = set(nums1)
        s2 = set(nums2)
        
        def inner(set1: Set[int], set2: Set[int]) -> List[int]:
            if len(set2) > len(set1):
                return inner(set2, set1)
            res = []
            for n in set2:
                if n in set1: res.append(n)
            return res 
            
        return inner(s1, s2)