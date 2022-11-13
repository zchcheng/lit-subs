public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String res = "";
        
        for(String s : strs) {
            res += String.format("%04d", s.length()) + s;
        }
        
        return res;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int index = 0;
        List<String> res = new ArrayList<>();
        
        while (index < s.length()) {
            int len = Integer.valueOf(s.substring(index, index + 4));
            index += 4;
            res.add(s.substring(index, index + len));
            index += len;
        }
        
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));