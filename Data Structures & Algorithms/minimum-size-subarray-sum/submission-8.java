class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int count = Integer.MAX_VALUE;
        int sum = 0;

        while (right < nums.length) {

            sum += nums[right++];

            while (sum >= target) {
                count = Math.min(count, right - left);
                sum -= nums[left++];
            }
        }

        return count == Integer.MAX_VALUE ? 0 : count;
    }
}