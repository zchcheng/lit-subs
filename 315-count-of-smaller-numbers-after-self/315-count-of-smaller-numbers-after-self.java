class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            list.add(new int[] { nums[i], i, 0 });
        }
        
        mergeSort(list, 0, list.size() - 1);
        
        List<Integer> res = Arrays.asList(new Integer[nums.length]);
        
        for(int[] el : list) res.set(el[1], el[2]);
        
        return res;
    }
    
    List<int[]> mergeSort(List<int[]> list, int l, int r) {
        if (l > r) return List.of();
        if (l == r) return List.of(list.get(l));
        
        int m = (l + r) / 2;
        
        List<int[]> ll = mergeSort(list, l, m);
        List<int[]> rl = mergeSort(list, m + 1, r);
        
        List<int[]> res = new ArrayList<>();
        
        int lp = 0;
        int rp = 0;
        int cnt = 0;
        
        while(lp < ll.size() || rp < rl.size()) {
            int vl = (lp >= ll.size())? Integer.MAX_VALUE : ll.get(lp)[0];
            int vr = (rp >= rl.size())? Integer.MAX_VALUE : rl.get(rp)[0];
            
            if (vl <= vr) {
                ll.get(lp)[2] += cnt;
                res.add(ll.get(lp++));
            } else {
                cnt++;
                res.add(rl.get(rp++));
            }
        }
        
        return res;
    }
}