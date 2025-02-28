package Solutions;

class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (tLen > sLen) return ""; // Edge case: t is longer than s

        int[] map=new int[128];
        for (char ch : t.toCharArray()) {
            map[ch]++;
        }
        
        int requiredMatches = t.length();
        int matchedCount = 0;
        int i = 0, j = 0, minLen = Integer.MAX_VALUE, startIdx = 0;
        while (j < sLen) {
            char ch = s.charAt(j);
            if (map[ch]>0) {
                matchedCount++;
            }
            map[ch]--;
            while (matchedCount == requiredMatches) {
                // Update result if found a smaller window
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    startIdx = i;
                }
                char temp = s.charAt(i);
                map[temp]++;
                if (map[temp]>0) {
                    matchedCount--;
                }
                i++;
            }
            j++;
        }
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
