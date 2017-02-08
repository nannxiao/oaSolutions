public class Solution {
    public int isValid(String s) {
        int count = 0;
        if (s == null || s.length() <= 1)   return count;
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '('|| s.charAt(i) == '{'||s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(' ){
                stack.pop();
                count ++;
            }
            else if(s.charAt(i) == '}' && !stack.empty() &&stack.peek() == '{' ){
                stack.pop();
                count ++;
            }
            else if(s.charAt(i) == ']' && !stack.empty() &&stack.peek() == '[' ){
                stack.pop();
                count ++;
            }
            else return -1;
        }
        // return true if no open parentheses left in stack
        return count;
        
    }
}
