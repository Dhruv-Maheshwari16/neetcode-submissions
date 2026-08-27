class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        

        for(int i = 0; i < nums.length-3;i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            long temp_target1 = target - nums[i];
            for(int j = i+1;j < nums.length - 2;j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) continue;

                long temp_target2 = temp_target1 - nums[j];
                int k = j + 1;
                int l = nums.length - 1;
                while(k < l) {
                    long sum = nums[k] + nums[l];
                    if(sum < temp_target2) {
                        k++;
                    }
                    else if(sum > temp_target2) {
                        l--;
                    }
                    else {
                        result.add(Arrays.asList(nums[i],nums[j],nums[k++],nums[l--]));
                        while(k < l && nums[k] == nums[k-1]) {
                            k++;
                        }
                    }
                }
            }
        }
        return result;
    }
}