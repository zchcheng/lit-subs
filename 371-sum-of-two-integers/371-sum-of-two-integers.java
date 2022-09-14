class Solution {
    public int getSum(int a, int b) {
        // ^ & <<
        
        int res = 0;
        int mask = 1;
        int c = 0;
        
        while(mask != 0) {
            int ma = ((mask & a) != 0)? 1 : 0;
            int mb = ((mask & b) != 0)? 1 : 0;
            
            res = res | (((ma ^ mb ^ c) != 0)? mask : 0);
            
            //System.out.println("ma: " + ma + ", mb: " + mb + ", c: " + c + ", res: " + res);
            
            c = ((ma == 1 && mb == 1) || (ma == 1 && c == 1) || (mb == 1 && c == 1))? 1 : 0;
            
            mask <<= 1;
        }
        
        return res;
    }
}