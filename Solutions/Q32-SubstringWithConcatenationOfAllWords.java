package Solutions;
import java.util.*;


class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();    
        int wordLen = words[0].length();
        int wordsCount = words.length;
        int totalLen = wordLen * wordsCount;
        int sLen = s.length();
        
        if (sLen < totalLen) return res;

        // Store word frequencies
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Slide over `wordLen` starting points to cover all possibilities
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> seenWords = new HashMap<>();
            
            while (right + wordLen <= sLen) {
                // Extract the current word
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                // If it's a valid word, process it
                if (wordMap.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    count++;

                    // If a word appears more than expected, shrink the window from the left
                    while (seenWords.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If all words match, store the starting index
                    if (count == wordsCount) {
                        res.add(left);
                    }
                } else {
                    // Reset window when encountering an invalid word
                    seenWords.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return res;
    }
}