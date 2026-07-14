class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[] {-1,-1};
        if(nums.length == 0 || nums.length == 1) {
            return result;
        }

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
            else {
                map.put(nums[i],i);
            } 
        }
        return result;
    } 
}
