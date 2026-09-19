class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = search(nums,left,right);
        return result;
    }

    private int search(int[] nums,int left,int right) {
        int res = nums[0];
        while(left <= right) {
            int mid = left + (right - left)/2;

            if(mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            else {
                res = search(nums,left,mid - 1);
                if(res != nums[0]) {
                    return res;
                }
                res = search(nums,mid + 1,right);
            }
            return res;
        }
        return res;
    }
}
