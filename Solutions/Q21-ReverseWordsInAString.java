package Solutions;


class Solution {
    public String reverseWords(String s) {
        StringBuilder str=new StringBuilder();
        
        int i=0,n=s.length();
        while(i<n)
        {
            if(s.charAt(i)!=' ')
            {
                int temp=i;
                while(i<n && s.charAt(i)!=' ')i++;

                if(!str.isEmpty()) str.insert(0,' ');
                str.insert(0,s.substring(temp,i));
            }
            else i++;
        }
        return str.toString();
    }
}