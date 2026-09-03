class Solution {
    public int trap(int[] height) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while(i < height.length) {
            if(stack.isEmpty()) {
                stack.push(i++);
                continue;
            }

            if(height[i] > height[stack.peek()]) {
                int temp = stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i++);
                    continue;
                }
                int pge = stack.peek();
                result += (Math.min(height[i],height[pge]) - height[temp])*(i - pge - 1);
                continue;
            }
            stack.push(i);
            i++;
        }
        return result;
    }
}
