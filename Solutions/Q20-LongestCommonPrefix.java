package Solutions;
import java.util.*;

//first solution:
/* 
class Solution {
    public static String commonPrefix(String str1,String str2)
    {
        int n=Math.min(str1.length(),str2.length());
        StringBuilder ans=new StringBuilder();
        int i=0;
        while(i<n && str1.charAt(i)==str2.charAt(i))
        {
            ans.append(str1.charAt(i));
            i++;
        }
        return ans.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        String res=strs[0];
        for(int i=1;i<n;i++)
        {
            res=commonPrefix(res,strs[i]);
            if(res.isEmpty()) return res;
        }
        return res;
    }
}
*/



//second solution:
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans=new StringBuilder();
        Arrays.sort(strs);//this will sort the array of strings in lexicographical order i.e. dictionary order.
        String str1=strs[0],str2=strs[strs.length-1];//checking directly between first and last string in the array.
        int n=Math.min(str1.length(),str2.length());
        int i=0;
        while(i<n && str1.charAt(i)==str2.charAt(i))
        {
            ans.append(str1.charAt(i));
            i++;
        }
        return ans.toString();
    }
}