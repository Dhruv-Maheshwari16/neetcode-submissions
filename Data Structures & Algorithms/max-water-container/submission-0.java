class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxsum = 0;
        while(left < right) {
            maxsum = Math.max(Math.min(heights[left],heights[right])*(right - left),maxsum);
            if(heights[left] < heights[right]) {
                left++;
            }
            else if(heights[right] < heights[left]) {
                right--;
            }
            else {
                if(Math.min(heights[left+1],heights[right])*(right - left+1) >
                    Math.min(heights[left],heights[right-1])*(right-1 - left)) {
                        left++;
                }
                else {
                    right--;
                }
            }
        }
        return maxsum;
    }
}
