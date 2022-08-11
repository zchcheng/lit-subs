class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> deps = new HashMap<>();
        int[] numOfDep = new int[numCourses];
        
        for(int[] pre : prerequisites) {
            int course = pre[0];
            int dep = pre[1];
            List<Integer> dc = deps.computeIfAbsent(dep, k -> new ArrayList<Integer>());
            dc.add(course);
            numOfDep[course] += 1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if (numOfDep[i] == 0) {
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int dep = queue.poll();
            List<Integer> list = deps.getOrDefault(dep, new ArrayList<>());
            for(int c : list) {
                if (--numOfDep[c] <= 0) {
                    queue.offer(c);
                }
            }
        }
        
        boolean result = true;
        
        for(int i = 0; i < numCourses; i++) result = result && numOfDep[i] == 0;
        
        return result;
    }
}