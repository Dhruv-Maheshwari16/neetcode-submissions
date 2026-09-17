class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = right - (right/2 - left/2);
            if(nums[mid] < target) {
                left = mid + 1;
            }
            else if(nums[mid] > target) {
                right = mid - 1;
            }
            else {
                index = mid;
                break;
            }
        }
        return index;
    }
}
