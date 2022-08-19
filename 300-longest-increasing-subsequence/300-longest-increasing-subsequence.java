class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int res = 0;
        
        for(int n : nums) {
            int i = lowerBound(list, n);
            
            if (i == list.size()) list.add(n);
            else list.set(i, n);
            
            res = Math.max(res, list.size());
        }
        
        return res;
    }
    
    int lowerBound(List<Integer> list, int t) {
        int l = 0;
        int r = list.size() - 1;
        
        while(l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m) >= t) r = m - 1; 
            else l = m + 1;
        }
        
        return l;
    }
}