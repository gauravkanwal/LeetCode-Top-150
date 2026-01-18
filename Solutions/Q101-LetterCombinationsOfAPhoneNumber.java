class Solution {
    String[] arr; 
    public List<String> letterCombinations(String digits) {
        arr=new String[]{"abc","def","ghi","jkl",
        "mno","pqrs","tuv", "wxyz"};
        List<String> res=new ArrayList<String> ();
        backtrack(new StringBuilder(),digits,res,0);
        return res;
    }

    private void backtrack(StringBuilder str,String digits,List<String> res,int idx)
    {
        char[] combination=arr[(digits.charAt(idx)-'0')-2].toCharArray();
        for(char c:combination){
            str.append(c);
            if(idx==digits.length()-1){
                res.add(str.toString());
            }else{
                backtrack(str,digits,res,idx+1);
            }
            str.deleteCharAt(str.length()-1);
        }
    }
}