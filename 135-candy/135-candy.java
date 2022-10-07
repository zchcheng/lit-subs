class Solution {
    public int candy(int[] ratings) {
        // 1 2 4 3 2 1
        // 1 2 3
        // <---> -> (1 + 3) * 3 / 2
        //     <-----> -> (1 + 4) * 4 / 2 -> - 3
        
        int result = 1;
        int up = 0, down = 0;
        int peak = 0;
        
        for(int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                down = 0;
                result += 1 + ++up;
                peak = up;
            } else if (ratings[i] < ratings[i - 1]) {
                up = 0;
                result += ++down;
                if (peak < down) result++;
            } else {
                result++;
                up = 0;
                down = 0;
                peak = 0;
            }
        }
        
        return result;
    }
}