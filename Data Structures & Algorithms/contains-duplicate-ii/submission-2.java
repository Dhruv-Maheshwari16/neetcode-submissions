class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>(k);

        for (int i = 0; i < nums.length; i++) {
            if (i >= k + 1)
                set.remove(nums[i - k - 1]);

            if (!set.add(nums[i]))
                return true;
        }

        return false;
    }
}