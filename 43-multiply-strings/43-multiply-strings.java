class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num1.equals("1")) return num2;
        if (num2.equals("1")) return num1;
        
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int[] res = new int[arr1.length + arr2.length] ;
        
        for(int i = arr2.length - 1; i >= 0; i--) {
            int m = Character.getNumericValue(arr2[i]);
            for(int j = arr1.length - 1; j >= 0; j--) {
                int n = Character.getNumericValue(arr1[j]);
                int idx = (arr2.length - 1 - i) + (arr1.length - 1 - j);
                int s = res[idx] + m * n;
                res[idx] = s % 10;
                res[idx + 1] = res[idx + 1] + s / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        boolean start = false;
        for(int i = res.length - 1; i >= 0; i--) {
            start = start || res[i] != 0;
            if (start) sb.append(res[i]);
        }
        
        return sb.toString();
    }
}