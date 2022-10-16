class Solution {
    Set<Integer> visited = new HashSet<>();
    
    public boolean sumOfNumberAndReverse(int num) {
        for(int i = num / 2; i <= num; i++) {
            if (canDo(i, num)) return true;
        }
        
        return false;
    }
    
    boolean canDo(int n, int num) {
        if (visited.contains(n)) return false;
        
        int r = reverse(n);
        
        visited.add(r);
        visited.add(n);
        
        return r + n == num;
    }
    
    int reverse(int n) {
        int r = 0;
        
        while(n > 0) {
            r = r * 10 + n % 10;
            n /= 10;
        }
        
        return r;
    }
}