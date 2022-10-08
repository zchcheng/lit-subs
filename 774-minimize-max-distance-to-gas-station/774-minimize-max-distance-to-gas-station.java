class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double l = 0, r = 1e8;
        
        while(r - l > 1e-6) {
            double m = (l + r) / 2.;
            if (canDo(stations, k, m)) r = m;
            else l = m;
        }
        
        return r;
    }
    
    boolean canDo(int[] stations, int k, double target) {
        int need = 0;
        for(int i = 1; i < stations.length; i++) {
            need += (stations[i] - stations[i - 1]) / target;
        }
        
        return need <= k;
    }
}