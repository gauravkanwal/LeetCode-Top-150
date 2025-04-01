package Solutions;

//hashmap solution:
// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {
//         HashMap<Character,Integer> magaMap=new HashMap<>();


//         for(int i=0;i<magazine.length();i++){
//             char s=magazine.charAt(i);
//             magaMap.put(s,magaMap.getOrDefault(s,0)+1);
//         }

//         for(int i=0;i<ransomNote.length();i++){
//             char s=ransomNote.charAt(i);
//             if(!magaMap.containsKey(s) || magaMap.get(s)==0)
//             {
//                 return false;
//             }
//             magaMap.put(s,magaMap.get(s)-1);
//         }
//         return true;
//     }
// }  

//array solution:
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];

        // Count frequencies of letters in magazine
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Check if ransomNote can be formed
        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false;
            }
            charCount[c - 'a']--;
        }

        return true;
    }
}