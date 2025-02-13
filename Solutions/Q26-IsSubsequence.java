package Solutions;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=s.length();
        if(n==0)return true;
        int m=t.length();
        int i=0;
        for(int j=0;j<m;j++)
        {
            if(s.charAt(i)==t.charAt(j))i++;
            if(i==n)return true;
        }
        return false;
    }
}