class Solution {
    public int firstMissingPositive(int[] nums) {
        int missing = 1;

        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        for(int i = 0; i < set.size();i++) {
            if(!set.contains(missing)) {
                return missing;
            }
            missing++;
        }
        return missing;
    }
}