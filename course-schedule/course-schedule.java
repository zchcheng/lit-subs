class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        
        for(int[] p : prerequisites) {
            inDegree[p[0]]++;
            neighbors.computeIfAbsent(p[1], k -> new HashSet<>()).add(p[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        
        while(!queue.isEmpty()) {
            int c = queue.poll();
            
            for(int n : neighbors.getOrDefault(c, new HashSet<>())) {
                if (--inDegree[n] <= 0) queue.offer(n);
            }
        }
        
        for(int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) return false;
        }
        
        return true;
    }
}