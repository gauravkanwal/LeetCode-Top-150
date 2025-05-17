class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        HashMap<Character,Character>map=new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        for(int i=0;i<s.length();i++){
            char bracket=s.charAt(i);
            if(bracket=='(' || bracket=='{' || bracket=='['){
                stack.push(bracket);
            }else {
                if(stack.isEmpty() || stack.peek()!=map.get(bracket)){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}