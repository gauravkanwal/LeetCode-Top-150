class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int sign=1;
        int result=0,number=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c == ' ') continue;
            else if(Character.isDigit(c)){
                number= (number*10) + (int)(c - '0');
            } else if(c=='+'){
                result+=sign*number;
                number=0;
                sign=1;
            } else if(c=='-'){
                result+=sign*number;
                number=0;
                sign=-1;
            } else if(c=='('){
                stack.push(result);
                stack.push(sign);
                sign=1;
                result=0;
            }else if(c==')'){
                result+=sign*number;
                number=0;
                int prevSign=stack.pop();
                int prevRes=stack.pop();
                result=prevRes+(prevSign*result);
            }
        }
        result+=sign*number;//if there is no paranthesis the last number is not added to result
        return result;
    }
}