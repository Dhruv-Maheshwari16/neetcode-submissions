class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int maximumArea = 0;
        for(int i = 0;i < n;i++) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int temp = stack.pop();
                int nse = i;
                int pse = -1;
                if(!stack.isEmpty()) {
                    pse = stack.peek();
                }
                maximumArea = Math.max(maximumArea,heights[temp]*(nse - pse - 1));
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int temp = stack.pop();
            int pse = -1;
            if(!stack.isEmpty()) {
                pse = stack.peek();
            }
            maximumArea = Math.max(maximumArea,heights[temp]*(n - pse - 1));
        }
        return maximumArea;
    }
}
