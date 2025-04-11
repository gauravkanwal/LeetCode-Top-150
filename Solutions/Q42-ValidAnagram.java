class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map=new int[26];
        if(s.length()!=t.length())return false; 
        int n=s.length(), total=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map[ch-'a']++;
            total++;
        }
        for(int i=0;i<n;i++){
            char ch=t.charAt(i);
            if(map[ch-'a']==0) return false;
            map[ch-'a']--;
            total--;
        }
        return total==0;
    }
}

//hashmap approach
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         HashMap<Character,Integer> map=new HashMap<>();
//         if(s.length()!=t.length())return false; 
//         int n=s.length();
//         for(int i=0;i<n;i++){
//             char ch=s.charAt(i);
//             map.put(ch,map.getOrDefault(ch,0)+1);
//         }
//         for(int i=0;i<n;i++){
//             char ch=t.charAt(i);
//             if(!map.containsKey(ch)) return false;
//             map.put(ch,map.get(ch)-1);
//             if(map.get(ch)==0) map.remove(ch);
//         }
//         return map.isEmpty();
//     }
// }