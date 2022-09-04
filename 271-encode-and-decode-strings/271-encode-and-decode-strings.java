public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for(String str : strs) {
            sb.append(String.format("%03d", str.length()));
            sb.append(str);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        
        while(!s.isEmpty()) {
            String chunk = s.substring(0, 3);
            s = s.substring(3);
            
            int len = Integer.parseInt(chunk);
            String sub = s.substring(0, len);
            s = s.substring(len);
            
            res.add(sub);
        }
        
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));