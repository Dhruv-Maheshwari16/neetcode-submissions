class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxsum = 0;
        while(left < right) {
            maxsum = Math.max(Math.min(heights[left],heights[right])*(right - left),maxsum);
            if(heights[left] <= heights[right]) {
                left++;
            }
            else if(heights[right] < heights[left]) {
                right--;
            }
        }
        return maxsum;
    }
}
