class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair<Integer, String>>> map = new HashMap<>();
        
        for(int i = 0; i < username.length; i++) {
            List<Pair<Integer, String>> list = map.computeIfAbsent(username[i], v -> new ArrayList<>());
            list.add(new Pair(timestamp[i], website[i]));
        }
        
        Map<Pattern, Integer> cnt = new HashMap<>();
        
        for(Map.Entry<String, List<Pair<Integer, String>>> kv : map.entrySet()) {
            List<Pair<Integer, String>> records = kv.getValue();
            records.sort((Pair<Integer, String> a, Pair<Integer, String> b) -> {
                return a.getKey() - b.getKey();
            });
            Set<Pattern> set = generate(records);
            
            for(Pattern p : set) {
                cnt.put(p, cnt.getOrDefault(p, 0) + 1);
            }
        }
        
        Pattern res = null;
        int times = 0;
        
        for(Map.Entry<Pattern, Integer> kv : cnt.entrySet()) {
            if (kv.getValue() > times || (times == kv.getValue() && kv.getKey().compareTo(res) < 0)) {
                res = kv.getKey();
                times = kv.getValue();
            }
        }
        
        return List.of(res.words[0], res.words[1], res.words[2]);
    }
    
    Set<Pattern> generate(List<Pair<Integer, String>> records) {
        Set<Pattern> res = new HashSet<>();
        
        for(int i = 0; i + 2 < records.size(); i++) {
            String s1 = records.get(i).getValue();
            for(int j = i + 1; j + 1 < records.size(); j++) {
                String s2 = records.get(j).getValue();
                for(int k = j + 1; k < records.size(); k++) {
                    String s3 = records.get(k).getValue();
                    Pattern p = new Pattern(new String[] {s1, s2, s3});
                    res.add(p);
                }
            }
        }
        
        return res;
    }
    
    class Pattern {
        public String[] words;
        
        public Pattern(String[] words) {
            this.words = words;
        }
        
        @Override
        public boolean equals(Object o) {
            Pattern p = (Pattern) o;
            return words[0].equals(p.words[0]) && words[1].equals(p.words[1]) && words[2].equals(p.words[2]);
        }
        
        @Override
        public int hashCode() {
            return toString().hashCode();
        }
        
        @Override
        public String toString() {
            return String.format("%s,%s,%s", words[0], words[1], words[2]);
        }
        
        public int compareTo(Pattern p) {
            for(int i = 0; i < 3; i++) {
                int cmp = words[i].compareTo(p.words[i]);
                if (cmp != 0) return cmp;
            }
            return 0;
        }
    }
}