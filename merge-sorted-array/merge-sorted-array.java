class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = nums1.length - 1, j = m - 1, k = n - 1; i >= 0; i--) {
            if (k < 0 || (j >= 0 && nums1[j] > nums2[k])) nums1[i] = nums1[j--];
            else nums1[i] = nums2[k--];
        }
    }
}