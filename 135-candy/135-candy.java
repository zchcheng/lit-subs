class Solution {
    public int candy(int[] ratings) {
        int up = 1;
        int down = 1;
        int result = 1;
        int peak = Integer.MAX_VALUE;
        
        for(int i = 1; i < ratings.length; i++) {
            if (ratings[i] == ratings[i - 1]) {
                result++;
                up = 1;
                down = 1;
                peak = Integer.MAX_VALUE;
            } else if (ratings[i] > ratings[i - 1]) {
                result += (++up);
                down = 0;
                peak = up;
            } else {
                result += 1 + down++;
                if (down >= peak) result++;
                up = 1;
            }
        }
        
        return result;
    }
}