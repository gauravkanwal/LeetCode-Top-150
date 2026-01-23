class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(res,n,0,0,new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, int n , int open, int closed, StringBuilder s)
    {
        if(closed>open) return;
        if(open>n) return;
        if(closed==n){
            String str=s.toString();
            res.add(str);
            return;
        } 

        s.append('(');
        backtrack(res,n,open+1,closed,s);
        s.deleteCharAt(s.length()-1);
        
        s.append(')');
        backtrack(res,n,open,closed+1,s);
        s.deleteCharAt(s.length()-1);
    }
}