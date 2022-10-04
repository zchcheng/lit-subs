class FileSystem {
    Directory root = new Directory(-1);

    public FileSystem() {
        
    }
    
    public boolean createPath(String path, int value) {
        String[] splited = path.split("/");
        
        Directory current = root;
        for(int i = 1; i < splited.length - 1 && current != null; i++) {
            current = current.dirs.get(splited[i]);
        }
        
        if (current == null || current.dirs.containsKey(splited[splited.length - 1])) return false;
        
        current.dirs.put(splited[splited.length - 1], new Directory(value));
        
        return true;
    }
    
    public int get(String path) {
        String[] splited = path.split("/");
        
        Directory current = root;
        
        for(int i = 1; i < splited.length && current != null; i++) {
            current = current.dirs.get(splited[i]);
        }
        
        if (current == null) return -1;
        
        return current.value;
    }
    
    class Directory {
        public Map<String, Directory> dirs = new HashMap<>();
        public int value = 0;
        
        public Directory(int val) {
            this.value = val;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */