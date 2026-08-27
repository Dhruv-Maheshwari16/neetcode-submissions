class Solution {
    public void rotate(int[] nums, int k) {
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k%nums.length-1);
        reverse(nums,k%nums.length,nums.length - 1);
    }

    private void reverse(int[] nums,int start,int end) {
        while(start < end) {
            swap(nums,start++,end--);
        }
    }

    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}