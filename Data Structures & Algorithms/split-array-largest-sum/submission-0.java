class Solution {
    public int splitArray(int[] nums, int k) {
        int left = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length;i++) {
            left = Math.max(left,nums[i]);
            sum += nums[i];
        }
        int right = sum;
        int res = sum;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int count = 0;
            int i = 0;
            while(i < nums.length) {
                int total = 0;
                while(i < nums.length && total + nums[i] <= mid) {
                    total += nums[i++]; 
                }
                count++;
            }

            if(count <= k) {
                res = Math.min(res,mid);
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return res;
    }
}