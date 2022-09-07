class FileSystem {
    Directory root = new Directory();

    public FileSystem() {
        
    }
    
    public List<String> ls(String path) {
        String[] splited = path.split("/");
        
        Directory curDir = root;
        
        for(int i = 0; i < splited.length - 1; i++) {
            if (!splited[i].isEmpty())
                curDir = curDir.directories.get(splited[i]);
        }
        
        if (curDir == null) return List.of();
        
        if (splited.length != 0 && curDir.files.containsKey(splited[splited.length - 1])) {
            return List.of(splited[splited.length - 1]);
        }
        
        if (splited.length != 0) {
            if (!curDir.directories.containsKey(splited[splited.length - 1])) return List.of();
            curDir = curDir.directories.get(splited[splited.length - 1]);
        }
        
        List<String> res = new ArrayList<>();
        
        res.addAll(curDir.directories.keySet());
        res.addAll(curDir.files.keySet());
        
        res.sort((a, b) -> a.compareTo(b));
        
        return res;
    }
    
    public void mkdir(String path) {
        String[] splited = path.split("/");
        
        Directory curDir = root;
        
        for(int i = 0; i < splited.length; i++) {
            if (!splited[i].isEmpty())
                curDir = curDir.directories.computeIfAbsent(splited[i], k -> new Directory());
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] splited = filePath.split("/");
        
        Directory curDir = root;
        
        for(int i = 0; i < splited.length - 1; i++) {
            if (!splited[i].isEmpty())
                curDir = curDir.directories.computeIfAbsent(splited[i], k -> new Directory());
        }
        
        File file = curDir.files.computeIfAbsent(splited[splited.length - 1], k -> new File());
        
        file.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        String[] splited = filePath.split("/");
        
        Directory curDir = root;
        
        for(int i = 0; i < splited.length - 1 && curDir != null; i++) {
            if (!splited[i].isEmpty())
                curDir = curDir.directories.get(splited[i]);
        }
        
        if (curDir == null || !curDir.files.containsKey(splited[splited.length - 1])) return "";
        
        return curDir.files.get(splited[splited.length - 1]).content;
    }
    
    class Directory {
        public Map<String, Directory> directories = new HashMap<>();
        public Map<String, File> files = new HashMap<>();
    }
    
    class File {
        public String content = "";
    }
}


/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */