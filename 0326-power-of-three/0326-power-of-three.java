class Solution {
    final int intMaxLog3 = (int)Math.pow(3, Math.floor((Math.log(Integer.MAX_VALUE) / Math.log(3))));
    public boolean isPowerOfThree(int n) {
        return n > 0 && intMaxLog3 % n == 0;
    }
}