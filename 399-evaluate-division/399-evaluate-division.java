class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> eqs = new HashMap<>();
        
        for(int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            double val = values[i];
            
            eqs.computeIfAbsent(eq.get(0), k -> new HashMap<>()).put(eq.get(1), val);
            eqs.computeIfAbsent(eq.get(1), k -> new HashMap<>()).put(eq.get(0), 1.0 / val);
        }
        
        double[] result = new double[queries.size()];
        
        for(int i = 0; i < result.length; i++) {
            result[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), eqs);
        }
        
        return result;
    }
    
    double bfs(String s, String e, Map<String, Map<String, Double>> eqs) {
        Queue<Pair<String, Double>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        if (eqs.containsKey(s)) {
            queue.offer(new Pair(s, 1.0));
            visited.add(s);
        }
        
        while(!queue.isEmpty()) {
            Pair<String, Double> p = queue.poll();
            
            if (p.getKey().equals(e)) return p.getValue();
            
            String k = p.getKey();
            double v = p.getValue();
            
            for(Map.Entry<String, Double> kv : eqs.get(p.getKey()).entrySet()) {
                if (visited.contains(kv.getKey())) continue;
                
                String sk = kv.getKey();
                double sv = kv.getValue();
                
                queue.offer(new Pair(sk, sv * v));
                
                visited.add(kv.getKey());
            }
        }
        
        return -1;
    }
}