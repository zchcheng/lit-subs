class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int l = 1, r = position[position.length - 1] - position[0];
        
        while(l <= r) {
            int min = l + (r - l) / 2;
            if (canDo(position, min, m)) l = min + 1;
            else r = min - 1;
        }
        
        return r;
    }
    
    boolean canDo(int[] position, int min, int m) {
        int prev = position[0];
        m--;
        
        for(int i = 1; i < position.length && m > 0; i++) {
            if (position[i] - prev >= min) {
                m--;
                prev = position[i];
            }
        }
        
        return m == 0;
    }
}