package Solutions;

class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int n=s.length();
        int j=n-1;
        while(i<=j)
        {
            if(!(Character.isLetterOrDigit(s.charAt(i)))) {i++; continue;}
            else if(!(Character.isLetterOrDigit(s.charAt(j)))) {j--; continue;}
            else 
            {
                if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) return false;
                i++;
                j--;
            }
        }
        return true;
    }
}