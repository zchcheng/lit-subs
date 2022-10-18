class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        res.add(List.of(1));
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prev = res.get(res.size() - 1);
            
            for(int j = 0; j <= prev.size(); j++) {
                if (j == 0 || j == prev.size()) row.add(1);
                else row.add(prev.get(j) + prev.get(j - 1));
            }
            
            res.add(row);
        }
        
        return res;
    }
}