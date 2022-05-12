class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < pid.size(); i++) {
            int p = pid.get(i);
            int pp = ppid.get(i);
            Set<Integer> set = map.computeIfAbsent(pp, v -> new HashSet<>());
            set.add(p);
        }
        
        List<Integer> res = new LinkedList<>();
        
        helper(kill, res, map);
        
        return res;
    }
    
    void helper(int p, List<Integer> res, Map<Integer, Set<Integer>> map) {
        Set<Integer> dep = map.get(p);
        
        if (dep != null) {
            for(Integer d : dep) {
                helper(d, res, map);
            }
        }
        
        res.add(p);
    }
}