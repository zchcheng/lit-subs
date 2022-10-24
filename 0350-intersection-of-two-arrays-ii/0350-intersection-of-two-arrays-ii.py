class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        
        if len(nums1) < len(nums2):
            return self.intersect(nums2, nums1)
        
        res = []
        cnt = {}
        
        for n in nums2:
            cnt[n] = cnt.get(n, 0) + 1
            
        for n in nums1:
            if cnt.get(n, 0) > 0:
                res.append(n)
                cnt[n] -= 1
                
            
        return res
        