class Solution {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        
        String[] arr = Arrays.stream(split).filter(str -> !str.isEmpty()).toArray(String[]::new);
        
        for(int i = 0; i < arr.length / 2; i++) {
            String tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
        
        return String.join(" ", arr);
    }
}