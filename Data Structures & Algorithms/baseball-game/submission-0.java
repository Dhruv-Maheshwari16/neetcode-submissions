class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String s : operations) {
            if(s.equals("+")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                int add = temp1 + temp2;
                stack.push(temp2);
                stack.push(temp1);
                stack.push(add);
                continue;
            }
            else if(s.equals("C")) {
                stack.pop();
                continue;
            }
            else if(s.equals("D")) {
                stack.push(stack.peek() * 2);
                continue;
            }
            else {
                stack.push(Integer.parseInt(s));
                continue;
            }
        }

        int sum = 0;

        for(int num : stack) {
            sum += num;
        }

        return sum;
    }
}