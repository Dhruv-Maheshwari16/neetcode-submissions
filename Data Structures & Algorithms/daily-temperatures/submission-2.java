class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int i = temperatures.length - 1 ; i >= 0 ; i--) {
            int t = temperatures[i];
            while(!stack.isEmpty() && t >= stack.peek()[0]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = 0;
            }
            else {
                result[i] = stack.peek()[1] - i;
            }
            stack.push(new int[]{t,i});
        }

        return result;
    }
}
