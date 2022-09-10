class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int idx = binSearch(arr, x);
        
        int r = idx;
        int l = idx - 1;
        
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < k; i++) {
            if (r >= arr.length) {
                l--;
                continue;
            } else if (l < 0) {
                r++;
                continue;
            }
            
            if (Math.abs(arr[r] - x) < Math.abs(x - arr[l])) r++;
            else l--;
        }
        
        for(int i = 0; i < k; i++) {
            res.add(arr[i + l + 1]);
        }
        
        return res;
    }
    
    int binSearch(int[] arr, int x) {
        int s = 0;
        int e = arr.length - 1;
        
        while(s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] < x) s = m + 1;
            else e = m - 1;
        }
        
        return s;
    }
}