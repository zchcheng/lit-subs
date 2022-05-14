class Solution {
    public int kthFactor(int n, int k) {
        int m = (int)Math.sqrt(n);
        
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        
        for(int i = 1; i <= m; i++) {
            if (n % i != 0) continue;
            l1.add(i);
            if (n / i > i) l2.add(n / i);
            else break;
        }
        
        if (k > l1.size() + l2.size()) return -1;
        
        if (k <= l1.size()) return l1.get(k - 1);
        
        return l2.get(l2.size() - k + l1.size());
    }
}