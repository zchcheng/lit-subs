class TimeMap {
    Map<String, List<Pair<Integer, String>>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> list = map.getOrDefault(key, new ArrayList<Pair<Integer, String>>());
        map.put(key, list);
        list.add(new Pair<Integer, String>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> list = map.get(key);
        if (list == null) return "";
        int index = findIndex(list, timestamp);
        if (index < 0) return "";
        return list.get(index).getValue();
    }
    
    int findIndex(List<Pair<Integer, String>> list, int tt) {
        int s = 0;
        int e = list.size() - 1;
        
        while(s <= e) {
            int mid = (s + e) / 2;
            int mt = list.get(mid).getKey();
            if (mt <= tt) { s = mid + 1; } 
            else { e = mid - 1; }
        }
        
        return e;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */