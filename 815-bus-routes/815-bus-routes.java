class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        
        Map<Integer, Set<Integer>> routeOfStops = new HashMap<>(); // stop -> routes
        
        for(int i = 0; i < routes.length; i++) {
            for(int r : routes[i]) {
                Set<Integer> set = routeOfStops.computeIfAbsent(r, k -> new HashSet<>());
                set.add(i);
            }
        }
        
        Map<Integer, Set<Integer>> connection = new HashMap<>();
        
        for(Map.Entry<Integer, Set<Integer>> kv : routeOfStops.entrySet()) {
            Set<Integer> connected = kv.getValue();
            
            for(int s1 : connected) {
                for(int s2 : connected) {
                    if (s1 == s2) continue;
                    connection.computeIfAbsent(s1, k -> new HashSet<>()).add(s2);
                    connection.computeIfAbsent(s2, k -> new HashSet<>()).add(s1);
                }
            }
        }
        
        Set<Integer> start = routeOfStops.getOrDefault(source, new HashSet<>());
        Set<Integer> end = routeOfStops.getOrDefault(target, new HashSet<>());
        
        if (start.isEmpty() || end.isEmpty()) return -1;
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int res = 1;
        
        for(int i : start) {
            queue.offer(i);
            visited.add(i);
        }
        
        while(!queue.isEmpty()) {
            int sz = queue.size();
            
            for(int i = 0; i < sz; i++) {
                int s = queue.poll();
                if (end.contains(s)) return res;

                Set<Integer> conn = connection.getOrDefault(s, new HashSet<>());

                for(int c : conn) {
                    if (visited.contains(c)) continue;
                    queue.offer(c);
                    visited.add(c);
                }
            }
            
            res++;
        }
        
        return -1;
    }
}