class Solution {
    // 1: "1"
    // 2: [[1,1]] -> "11"
    // 3: [[1, 2]] -> "21"
    // 4: [[2,1], [1,1]] -> "1211"
    // 5: [[1,1],[2,1],[1,2]] -> 111221
    
    public String countAndSay(int n) {
        String result = "1";
        
        for(int i = 2; i <= n; i++) {
            List<int[]> digitCounter = new ArrayList<>();
            
            int cnt = 1;
            int currentDigit = result.charAt(0) - '0';
            
            for(int j = 1; j < result.length(); j++) {
                int d = result.charAt(j) - '0';
                
                if (d == currentDigit) {
                    cnt++;
                    continue;
                }
                
                digitCounter.add(new int[] {cnt, currentDigit});
                
                cnt = 1;
                currentDigit = d;
            }
            
            digitCounter.add(new int[] {cnt, currentDigit});
            
            String next = "";
            
            for(int[] dc : digitCounter) {
                next += dc[0] + "" + dc[1];
            }
            
            result = next;
        }
        
        return result;
    }
}