class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;
        
        while(i >= 0 || j >= 0) {
            int vi = (i >= 0)? nums1[i] : Integer.MIN_VALUE;
            int vj = (j >= 0)? nums2[j] : Integer.MIN_VALUE;
            
            if (vi > vj) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}