class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        return (getK(nums1, 0, nums2, 0, (n1 + n2 + 1) / 2) + getK(nums1, 0, nums2, 0, (n1 + n2) / 2 + 1)) / 2;
    }
    
    double getK(int[] n1, int i, int[] n2, int j, int k) {
        if (i >= n1.length) return n2[j + k - 1];
        if (j >= n2.length) return n1[i + k - 1];
        if (k == 1) return Math.min(n1[i], n2[j]);
        
        int m1 = (i + (k / 2) - 1);
        int m2 = (j + (k / 2) - 1);
        
        int m1v = (m1 < n1.length)? n1[m1] : Integer.MAX_VALUE;
        int m2v = (m2 < n2.length)? n2[m2] : Integer.MAX_VALUE;
        
        if (m1v < m2v) return getK(n1, m1 + 1, n2, j, k - k / 2);
        else return getK(n1, i, n2, m2 + 1, k - k / 2);
    }
}