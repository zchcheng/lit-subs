class Solution {
    public String simplifyPath(String path) {
        
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for(String p : split) {
            if (p.equals(".") || p.isEmpty()) {
                continue;
            }
            
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
                continue;
            }
            
            stack.push(p);
        }
        
        List<String> list = new ArrayList<>();
        
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        
        Collections.reverse(list);
        
        return "/" + String.join("/", list);
    }
}