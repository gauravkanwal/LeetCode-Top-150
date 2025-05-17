class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<>();
        int n=path.length();
        
        //filling the stack with strings seprated by '/' :
        int i=0;
        while(i<n){

            while(i<n && path.charAt(i)=='/') i++;
            
            StringBuilder sb=new StringBuilder();
            while(i<n && path.charAt(i)!='/'){
                sb.append(path.charAt(i));
                i++;
            }

            if(sb.length()!=0){
                String str=sb.toString();
                if(str.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                } else if(!str.equals(".")){
                    stack.push(str);
                }
            }
            i++;
        }

        //building the final path:
        StringBuilder ans=new StringBuilder();
        for (String dir : stack) {
            ans.append("/").append(dir);
        }

        return ans.length()==0? "/" :ans.toString(); 
    }
}