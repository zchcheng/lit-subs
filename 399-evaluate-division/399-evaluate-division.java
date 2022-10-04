class Solution {
    Map<String, String> grp = new HashMap<>();
    Map<String, Double> weight = new HashMap<>();
    int cnt = 0;
        
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        
        for(int i = 0; i < equations.size(); i++) {
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        
        for(int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            
            if (!grp.containsKey(a) || !grp.containsKey(b)) {
                result[i] = -1;
                continue;
            }
            
            Pair<String, Double> p1 = find(a);
            Pair<String, Double> p2 = find(b);
            
            if (!p1.getKey().equals(p2.getKey())) result[i] = -1;
            else result[i] = p1.getValue() / p2.getValue();
        }
        
        return result;
    }
    
    void union(String a, String b, double w) {
        Pair<String, Double> p1 = find(a);
        Pair<String, Double> p2 = find(b);
        
        grp.put(p1.getKey(), p2.getKey());
        weight.put(p1.getKey(), p2.getValue() * w / p1.getValue());
    }
    
    Pair<String, Double> find(String i) {
        if (grp.computeIfAbsent(i, k -> i).equals(i)) {
            weight.put(i, 1.);
            return new Pair<>(i, 1.);
        }
        
        Pair<String, Double> p = find(grp.get(i));
        
        grp.put(i, p.getKey());
        weight.put(i, p.getValue() * weight.get(i));
        
        return new Pair<>(grp.get(i), weight.get(i));
    }
}