import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        HashMap<Character, String> patternMap = new HashMap<>();
        HashMap<String, Character> sMap = new HashMap<>();
        
        int i = 0, j = 0;
        while (i < pattern.length() || j < s.length()) {
            if (i >= pattern.length() || j >= s.length()) return false;

            char ch = pattern.charAt(i);
            int k = j;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            String str = s.substring(k, j);
            
            if (patternMap.containsKey(ch) && !patternMap.get(ch).equals(str)) {
                return false;
            }
            if (sMap.containsKey(str) && sMap.get(str) != ch) {
                return false;
            }

            patternMap.put(ch, str);
            sMap.put(str, ch);

            i++;
            j++;
        }

        return true;
    }
}
