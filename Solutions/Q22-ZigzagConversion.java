package Solutions;

class Solution {
    public String convert(String s, int numRows) {
        int n=s.length();
        if(numRows<=1 || n<= numRows) return s;
        StringBuilder ans=new StringBuilder();
        StringBuilder[] arr=new StringBuilder[numRows];
        int i=0;
        int j=0;
        Boolean forward=true;

        // Initialize StringBuilder for each row
        for (int k = 0; k < numRows; k++) {
            arr[k] = new StringBuilder();
        } 

        //filling every row
        while(i<n)
        {   
            arr[j].append(s.charAt(i));
            
            if(forward)j++;
            else j--;

            if(j==numRows-1||j==0)forward=!forward;
            i++;
        }

        //merging for answer.
        for(StringBuilder str:arr)
        {
           if(str!=null) ans.append(str.toString());
        }
        return ans.toString();
    }
}
