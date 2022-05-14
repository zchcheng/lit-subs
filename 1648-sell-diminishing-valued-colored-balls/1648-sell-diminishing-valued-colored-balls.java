class Solution {
    int K = 1000000007;
    
    public int maxProfit(int[] inventory, int orders) {
        Map<Integer, Integer> bucket = new HashMap<>();
        
        for(int i : inventory) {
            bucket.put(i, bucket.getOrDefault(i, 0) + 1);
        }
        
        List<int[]> list = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> kv : bucket.entrySet()) {
            list.add(new int[] { kv.getKey(), kv.getValue() });
        }
        
        list.sort((int[] a, int[] b) -> {
            return b[0] - a[0];
        });
            
        long res = 0;
        
        for(int i = 0; i < list.size() && orders > 0;) {
            int[] p = list.get(i);
            int[] np = (i == list.size() - 1)? new int[] {0, 0} : list.get(i + 1);
            
            long n = Math.min(p[0] - np[0], orders / p[1]);
            
            if (n == 0) {
                res = add(res, (long)orders * p[0]);
                orders = 0;
                continue;
            }
            
            res = add(res, gain(p[0], n) * p[1]);
            
            orders -= p[1] * n;
            p[0] -= n;
            
            if (p[0] == np[0]) {
                np[1] += p[1];
                i++;
            }
        }
        
        return (int)res;
    }
    
    long add(long a, long b) {
        return (a % K + b % K) % K;
    }
    
    long gain(long ub, long n) {
        return (ub + (ub - n + 1)) * n / 2;
    }
}