class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        
        int l = 0;
        int r = arr.length - k - 1;
        
        while(l <= r) {
            int m = l + (r - l) / 2;
            if (x - arr[m] > arr[m + k] - x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        for(int i = l; i < l + k; i++) {
            res.add(arr[i]);
        }
        
        return res;
    }
}