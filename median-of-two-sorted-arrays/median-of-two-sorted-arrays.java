class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int tn = (nums1.length + nums2.length);
        int k1 = tn / 2 + 1;
        double m1 = (double)getKth(nums1, 0, nums2, 0, k1);
        
        if (tn % 2 != 0) return m1;
        
        int k2 = k1 - 1;
        return ((double)getKth(nums1, 0, nums2, 0, k2) + m1) / 2.0;
    }
    
    int getKth(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if (s1 >= nums1.length) return nums2[s2 + k - 1];
        if (s2 >= nums2.length) return nums1[s1 + k - 1];
        
        if (k == 1) return Math.min(nums1[s1], nums2[s2]);
        
        int t = k / 2;
            
        int k1 = Math.min(nums1.length - 1, s1 + t - 1);
        int m1 = nums1[k1];
        
        int k2 = Math.min(nums2.length - 1, s2 + t - 1);
        int m2 = nums2[k2];
        
        if (m1 < m2) return getKth(nums1, k1 + 1, nums2, s2, k - (k1 - s1 + 1));
        else return getKth(nums1, s1, nums2, k2 + 1, k - (k2 - s2 + 1));
    }
}