class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character>map =new HashMap<>();
        HashMap<Character,Character>map2 =new HashMap<>();

        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            char ch2=t.charAt(i);
            if(map.containsKey(ch) && map.get(ch)!=ch2) return false;
            if(map2.containsKey(ch2) && map2.get(ch2)!=ch) return false;

            map.put(ch,ch2);
            map2.put(ch2,ch);
        }
        return true;
    }
}