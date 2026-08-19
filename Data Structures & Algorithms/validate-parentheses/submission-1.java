class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for(char c : arr) {
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            
            char top = stack.peek();
            if(top == '(' && c == ')') {
                stack.pop();
            }
            else if(top == '[' && c == ']') {
                stack.pop();
            }
            else if(top == '{' && c == '}') {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
