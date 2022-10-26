class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        k = len(nums1) + len(nums2)
        if k % 2 == 1:
            return self.helper(nums1, nums2, 0, 0, k // 2 + 1)
        return (self.helper(nums1, nums2, 0, 0, k // 2) + self.helper(nums1, nums2, 0, 0, k // 2 + 1)) / 2
        
        
    def helper(self, nums1: List[int], nums2: List[int], i1: int, i2: int, k: int) -> int:
        if i1 >= len(nums1):
            return nums2[i2 + k - 1]
        if i2 >= len(nums2):
            return nums1[i1 + k - 1]
        
        if k == 1:
            return min(nums1[i1], nums2[i2])
        
        h = k // 2
        
        l1 = len(nums1) - i1
        l2 = len(nums2) - i2
        
        h1 = h if l1 >= h else l1
        h2 = h if l2 >= h else l2
        
        if nums1[i1 + h1 - 1] <= nums2[i2 + h2 - 1]:
            return self.helper(nums1, nums2, i1 + h1, i2, k - h1)
        else:
            return self.helper(nums1, nums2, i1, i2 + h2, k - h2)