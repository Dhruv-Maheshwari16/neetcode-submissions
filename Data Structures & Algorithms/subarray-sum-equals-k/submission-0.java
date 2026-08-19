class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        int prefix = 0;
        int count = 0;

        map.put(0,1);

        for(int num : nums) {
            prefix += num;
            int diff = prefix - k;
            count += map.getOrDefault(diff,0);
            map.put(prefix,map.getOrDefault(prefix,0) + 1);
        }

        return count;
    }
}