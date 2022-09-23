class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();
    
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        buildGraph(connections);
        helper(0, -1, 0);
        return result;
    }
    
    int helper(int current, int prev, int prevRank) {
        if (rank.containsKey(current)) return rank.get(current);
        
        int currentRank = prevRank + 1;
        
        int reachMinRank = currentRank;
        rank.put(current, reachMinRank);
        
        for(int neighbor : graph.getOrDefault(current, new HashSet<>())) {
            if (neighbor == prev) continue;
            
            int minRank = helper(neighbor, current, currentRank);
            
            if (minRank == currentRank + 1) {
                result.add(List.of(current, neighbor));
            }
            
            reachMinRank = Math.min(reachMinRank, minRank);
        }
        
        return reachMinRank;
    }
    
    void buildGraph(List<List<Integer>> connections) {
        for(List<Integer> conn : connections) {
            graph.computeIfAbsent(conn.get(0), k -> new HashSet<>()).add(conn.get(1));
            graph.computeIfAbsent(conn.get(1), k -> new HashSet<>()).add(conn.get(0));
        }
    }
}