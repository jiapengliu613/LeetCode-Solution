public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('/').append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int pos = 0;
        while (pos < s.length()) {
            int index = s.indexOf('/', pos);
            int length = Integer.parseInt(s.substring(pos,index));
            result.add(s.substring(index + 1, index + length + 1));
            pos = index + length + 1;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));