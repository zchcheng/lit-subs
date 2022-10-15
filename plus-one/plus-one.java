class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        
        int c = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int s = digits[i] + c;
            list.add(s % 10);
            c = s / 10;
        }
        
        if (c != 0) list.add(c);
        
        int[] result = new int[list.size()];
        
        for(int i = 0; i < result.length; i++) result[i] = list.get(list.size() - 1 - i);
        
        return result;
    }
}