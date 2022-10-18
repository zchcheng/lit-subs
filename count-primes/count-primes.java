class Solution {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int result = 0;
        
        for(int i = 2; i < n; i++) {
            if (notPrimes[i - 1]) continue;
            result += 1;
            for(int j = 2; j * i < n; j++) {
                notPrimes[j * i - 1] = true;
            }
        }
        
        return result;
    }
}