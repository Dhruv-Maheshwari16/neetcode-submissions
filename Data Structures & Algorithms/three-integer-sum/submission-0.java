class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0] > 0) {
            return res;
        }

        for(int i = 0 ; i < nums.length;i++) {
            int target = (-1)*nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int temp = nums[j] + nums[k];
                if(temp < target) {
                    j++;
                }
                else if(temp > target) {
                    k--;
                }
                else {
                    List<Integer> temp_result = new ArrayList<>();
                    temp_result.add(nums[i]);
                    temp_result.add(nums[j++]);
                    temp_result.add(nums[k--]);
                    if(!res.contains(temp_result)) {
                        res.add(temp_result);
                    }
                }
            }
        }
        return res;
    }
}
