class Solution {
    public int minMovesToMakePalindrome(String s) {
        int l = 0, r = s.length() - 1, m = r / 2, result = 0;
        
        char[] arr = s.toCharArray();
        
        while(l < r) {
            int g = find(arr, l, r);
            
            if (g == l) { 
                swap(arr, l, l + 1);
                result += 1;
            } else {
                swap(arr, g, r);
                result += r - g;
                l++;
                r--;
            }
        }
        
        return result;
    }
    
    int find(char[] arr, int l, int r) {
        for(int i = r; i > l; i--) {
            if (arr[i] == arr[l]) return i;
        }
        return l;
    }
    
    void swap(char[] arr, int from, int to) {
        while(from != to) {
            if (from < to) swapEl(arr, from, ++from);
            else swapEl(arr, from, --from);
        }
    }
    
    void swapEl(char[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}