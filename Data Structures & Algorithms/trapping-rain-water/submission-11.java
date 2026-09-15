class Solution {
    public int trap(int[] height) {
        int left = 0;
        int leftMax = height[left];
        int right = height.length - 1;
        int rightMax = height[right];
        int water = 0;
        while(left < right) {
            if(leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax,height[left]);
                water += leftMax - height[left];
            }
            else {
                right--;
                rightMax = Math.max(rightMax,height[right]);
                water += rightMax - height[right];
            }
        }
        return water;
    }
}
