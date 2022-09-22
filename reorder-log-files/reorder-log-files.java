class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> dlogs = new ArrayList<>();
        List<String> llogs = new ArrayList<>();
        
        for(String log : logs) {
            if (isLetterLog(log)) llogs.add(log);
            else dlogs.add(log);
        }
        
        Collections.sort(llogs, (a, b) -> {
            String[] splited1 = a.split(" ", 2);
            String[] splited2 = b.split(" ", 2);
            if (splited1[1].equals(splited2[1])) return splited1[0].compareTo(splited2[0]);
            return splited1[1].compareTo(splited2[1]);
        });
        
        String[] res = new String[logs.length];
        
        int idx = 0;
        for(String log : llogs) {
            res[idx++] = log;
        }
        
        for(String log : dlogs) {
            res[idx++] = log;
        }
        
        return res;
    }
    
    boolean isLetterLog(String log) {
        String[] splited = log.split(" ", 2);
        
        for(char c : splited[1].toCharArray()) {
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') return false;
        }
        
        return true;
    }
}