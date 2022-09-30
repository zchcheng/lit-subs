class Solution {
    public int candy(int[] ratings) {
        int[] numOfCandyNeeded = new int[ratings.length];
        numOfCandyNeeded[0] = 1;
        
        for(int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) numOfCandyNeeded[i] = numOfCandyNeeded[i - 1] + 1;
            else numOfCandyNeeded[i] = 1;
        }
        
        for(int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) numOfCandyNeeded[i] = Math.max(numOfCandyNeeded[i], numOfCandyNeeded[i + 1] + 1);
            else numOfCandyNeeded[i] = Math.max(1, numOfCandyNeeded[i]);
        }
        
        int result = 0;
        for(int i = 0; i < ratings.length; i++) {
            result += numOfCandyNeeded[i];
        }
        
        return result;
    }
    
    void print(int[] arr) {
        System.out.print("[");
        for(int n : arr) System.out.print(n + " ");
        System.out.print("]");
        System.out.println();
    }
}