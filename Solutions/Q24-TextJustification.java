package Solutions;
import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List <String> result=new ArrayList<>();
        int n=words.length;
        int start=0;
        while(start<n)
        {
            int end=findEnd(start,words,maxWidth);
            String str=justifyLine(words,start,end,maxWidth);
            result.add(str);
            start=end+1;
        }
        return result;
    }

//function to return end index of a string array according to the maxWidth;
    private int findEnd(int start,String[] words,int maxWidth)
    {
        if(start==words.length-1) return start;
        int end=start;
        int len=words[start].length();
        while(end+1<words.length &&(len + 1 + words[end + 1].length()) <= maxWidth)
        {
            end++;
            len+=1+words[end].length();
        }    
        return end;
    }

//function to return given number of spaces
    private String addSpaces(int number)
    {
        return " ".repeat(number);
    }


    //function for justifying a line
    private String justifyLine(String[] words,int start,int end,int maxW)
    {
        int n=words.length;
        StringBuilder ans=new StringBuilder();

        //if only single word
        if(start==end)
        {
            ans.append(words[start]);
            ans.append(addSpaces(maxW-words[start].length()));
            return ans.toString();
        }

        //if its the last sentence
        else if(end==n-1)
        {   
            while(start<=end)
            {
                ans.append(words[start]);
                if(start<end)ans.append(" ");
                start++;
            }
            while (ans.length() < maxW) ans.append(" "); 
            return ans.toString();
        }

        //otherwise
        int len = 0;
        for (int i = start; i <= end; i++) {
            len += words[i].length();
        }
        int gaps=end-start;
        int numOfSpaces=maxW-len;
        int spacesPerGap=numOfSpaces/gaps;
        int remainingGaps=numOfSpaces%gaps;
        ans.append(words[start]);
        start++;
        while(start<=end)
        {
            if(remainingGaps>0){
                ans.append(" ");
                remainingGaps--;
            }
            ans.append(addSpaces(spacesPerGap));
            ans.append(words[start]);
            start++;
        }
        return ans.toString();
    }
}