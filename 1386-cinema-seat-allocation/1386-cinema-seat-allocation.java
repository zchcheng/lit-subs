class Solution {
    public int maxNumberOfFamilies(int n, int[][] rs) {
        Map<Integer, boolean[]> map = new HashMap<>();
        
        for(int[] r : rs) {
            if (r[1] == 1 || r[1] == 10) continue;
            
            boolean[] arr = map.computeIfAbsent(r[0] - 1, i -> new boolean[3]);
            
            if (2 <= r[1] && r[1] <= 3) { arr[0] = true; }
            else if (4 <= r[1] && r[1] <= 5) { arr[0] = true; arr[1] = true; }
            else if (6 <= r[1] && r[1] <= 7) { arr[1] = true; arr[2] = true; }
            else { arr[2] = true; }
        }
        
        int res = 2 * (n - map.size());
        
        for(Map.Entry<Integer, boolean[]> kv : map.entrySet()) {
            boolean[] p = kv.getValue();
            res += (p[0] && p[1] && p[2])? 0 : 1;
        }
        
        return res;
    }
}