class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length;i++) {
            int temp = nums[Math.abs(nums[i])];
            if(temp < 0) {
                return Math.abs(nums[i]);
            }
            nums[Math.abs(nums[i])] = nums[Math.abs(nums[i])]*(-1);
        }
        return nums[0];
    }
}
