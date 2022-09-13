class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, Set<Integer>> dep = new HashMap<>();
        
        for(int[] p : prerequisites) {
            inDegree[p[0]]++;
            Set<Integer> d = dep.computeIfAbsent(p[1], k -> new HashSet<>());
            d.add(p[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        
        while(!queue.isEmpty()) {
            int c = queue.poll();
            
            Set<Integer> s = dep.getOrDefault(c, new HashSet<>());
            
            for(int el : s) {
                inDegree[el]--;
                if (inDegree[el] <= 0) queue.offer(el);
            }
        }
        
        for(int id : inDegree) {
            if (id != 0) return false;
        }
        
        return true;
    }
}