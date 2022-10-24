class Solution {
    public int subarrayGCD(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int r = 0;
        
        for(int n : nums) {
            Map<Integer, Integer> nxt = new HashMap<>();
            
            if (n % k == 0) {
                m.put(n, m.getOrDefault(n, 0) + 1);
                for(Map.Entry<Integer, Integer> kv : m.entrySet()) {
                    int g = gcd(kv.getKey(), n);
                    nxt.put(g, kv.getValue() + nxt.getOrDefault(g, 0));
                }
            }
            
            r += nxt.getOrDefault(k, 0);
            m = nxt;
        }
        
        return r;
    }
    
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}