class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        
        i = len(nums1) - 1
        j = m - 1
        k = n - 1
        
        while j >= 0 or k >= 0:
            v1 = nums1[j] if j >= 0 else float('-inf')
            v2 = nums2[k] if k >= 0 else float('-inf')
            
            if v1 >= v2:
                nums1[i] = v1
                j -= 1
            else:
                nums1[i] = v2
                k -= 1
                
            i -= 1
