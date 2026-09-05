class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < k+1 && i < nums.length;i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        int i = k+1;
        while(i < nums.length) {
            set.remove(nums[i - k - 1]);
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i++]);
        }
        return false;
    }
}