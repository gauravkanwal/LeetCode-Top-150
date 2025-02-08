package Solutions;

//my solution:
class Solution {
    public int strStr(String haystack, String needle) {
        int n=needle.length();
        int m=haystack.length();
        int i=0,j=0;
        while(i<m && j<n)
        {
            if(needle.charAt(j)==haystack.charAt(i)){
                j++;
            }
            else if(j>0)
            {
                i-=j;
                j=0;
            }
            i++;
        }
        if(j==n)return i-n;
        return -1;
    }

}