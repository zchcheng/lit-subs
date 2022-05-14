class Solution {
    public int kthFactor(int n, int k) {
        int m = (int)Math.sqrt(n);
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= m; i++) {
            if (n % i != 0) continue;
            list.add(i);
        }
        
        int d = (m * m == n)? 1 : 0;
        
        if (k > list.size() * 2 - d) return -1;
        
        if (k <= list.size()) return list.get(k - 1);
        
        return n / list.get(list.size() - (k - list.size()) - d);
    }
}