class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        
        Arrays.fill(arr, 1);
        
        for(int i = 0, pl = Integer.MAX_VALUE, plv = 1, pr = Integer.MAX_VALUE, prv = 1; i < n; i++) {
            arr[i] = (ratings[i] > pl)? Math.max(++plv, arr[i]) : arr[i];
            arr[n - 1 - i] = (ratings[n - 1 - i] > pr)? Math.max(++prv, arr[n - 1 - i]) : arr[n - 1 - i];
            
            plv = arr[i];
            prv = arr[n - 1 - i];
            pl = ratings[i];
            pr = ratings[n - 1 - i];
        }
        
        int result = 0;
        for(int i = 0; i < arr.length; i++) result += arr[i];
        
        return result;
    }
}