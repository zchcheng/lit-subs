class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        
        int m = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                m = i;
                break;
            }
        }
        
        int n = arr.length - 1;
        for(int j = arr.length - 1; j >= m; j--) {
            if (arr[j] > arr[n]) n = j;
        }
        
        for(int i = m; i >= 0; i--) {
            if (arr[i] < arr[n]) { m = i; }
        }
        
        if (m < n) swap(arr, m, n);
        
        return Integer.valueOf(String.valueOf(arr));
    }
    
    void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}