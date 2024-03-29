class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> occurence = new HashMap<>();
        Map<Integer, Integer> numOfOccurence = new HashMap<>();
        
        for(int t : tasks) {
            occurence.put(t, occurence.getOrDefault(t, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> kv : occurence.entrySet()) {
            int o = kv.getValue();
            numOfOccurence.put(o, numOfOccurence.getOrDefault(o, 0) + 1);
        }
        
        int res = 0;
        
        for(Map.Entry<Integer, Integer> kv : numOfOccurence.entrySet()) {
            int k = kv.getKey();
            int v = kv.getValue();
            if (k == 1) return -1;
            
            if (k == 2) res += v;
            else if (k % 3 == 0) res += (k / 3) * v;
            else if (k % 3 == 1) res += (((k / 3) - 1) + 2) * v;
            else if (k % 3 == 2) res += ((k / 3) + 1) * v;
        }
        
        return res;
    }
}