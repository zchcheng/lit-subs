class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        
        int[][] freqs = new int[freq.size()][2];
        
        int i = 0;
        for(Map.Entry<Integer, Integer> kv : freq.entrySet()) {
            freqs[i++] = new int[] {kv.getValue(), kv.getKey()};
        }
        
        quickSelect(freqs, k, 0, freqs.length - 1);
        
        int[] result = new int[k];
        
        for(int j = 0; j < k; j++) {
            result[j] = freqs[j][1];
        }
        
        return result;
    }
    
    void quickSelect(int[][] freqs, int k, int l, int r) {
        if (r <= k) return;
        
        int nk = partition(freqs, l, r);
        
        if (nk == k) return;
        
        if (nk < k) quickSelect(freqs, k, nk + 1, r);
        else quickSelect(freqs, k, l, nk - 1);
    }
    
    int partition(int[][] freqs, int l, int r) {
        int v = freqs[l][0];
        
        int j = l + 1;
        for(int i = l + 1; i <= r; i++) {
            int cv = freqs[i][0];
            
            if (cv >= v) {
                swap(freqs, i, j++);
            }
        }
        
        swap(freqs, l, j - 1);
        
        return j - 1;
    }
    
    void swap(int[][] freqs, int a, int b) {
        int i0 = freqs[a][0];
        int i1 = freqs[a][1];
        
        freqs[a][0] = freqs[b][0];
        freqs[a][1] = freqs[b][1];
        
        freqs[b][0] = i0;
        freqs[b][1] = i1;
    }
}