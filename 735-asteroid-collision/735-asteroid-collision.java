class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();
        Deque<Integer> stack = list;
        
        for(int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            
            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            
            while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroid) > stack.peek()) stack.pop();
            
            if (stack.isEmpty() || stack.peek() < 0) stack.push(asteroid);
            if (!stack.isEmpty() && stack.peek() == -asteroid) stack.pop();
        }
        
        Collections.reverse(list);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}