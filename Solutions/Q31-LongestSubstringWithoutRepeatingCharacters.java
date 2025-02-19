package Solutions;
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>set =new HashSet<>();
        int i=0,j=0;
        int n=s.length();
        int res=0;
        while(j<n)
        {
            while(set.contains(s.charAt(j)))
            {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            res=Math.max(res,j-i+1);
            j++;
        }
        return res;
    }
}