class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String token : tokens) {
            int temp1;
            int temp2;
            switch(token) {
                case "+" :
                    temp1 = stack.pop();
                    temp2 = stack.pop();
                    stack.push(temp1 + temp2);
                    break;

                case "-" :
                    temp1 = stack.pop();
                    temp2 = stack.pop();
                    stack.push(temp2 - temp1);
                    break;

                case "*" :
                    temp1 = stack.pop();
                    temp2 = stack.pop();
                    stack.push(temp1 * temp2);
                    break;

                case "/" :
                    temp1 = stack.pop();
                    temp2 = stack.pop();
                    if(temp1 != 0) {
                        stack.push(temp2 / temp1);
                    }
                    else {
                        stack.push(temp2);
                    }
                    break;

                default :
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
