class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0] > 0) {
            return res;
        }

        for(int i = 0 ; i < nums.length;i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
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
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
