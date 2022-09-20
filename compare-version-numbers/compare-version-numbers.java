class Solution {
    public int compareVersion(String version1, String version2) {
        int[] v1 = getVersionNumericValue(version1);
        int[] v2 = getVersionNumericValue(version2);
        
        int i = 0, j = 0;
        while(i < v1.length || j < v2.length) {
            int vv1 = (i < v1.length)? v1[i++] : 0;
            int vv2 = (j < v2.length)? v2[j++] : 0;
            
            if (vv1 > vv2) return 1;
            if (vv1 < vv2) return -1;
        }
        
        return 0;
    }
    
    int[] getVersionNumericValue(String version) {
        String[] splited = version.split("\\.");
        
        int[] result = new int[splited.length];
        
        for(int i = 0; i < splited.length; i++) {
            result[i] = Integer.valueOf(splited[i]);
        }
        
        return result;
    }
}