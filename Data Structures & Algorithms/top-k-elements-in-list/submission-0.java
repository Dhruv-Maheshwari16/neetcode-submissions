class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<>();
        ArrayList<Integer>[] freq = new ArrayList[nums.length + 1];

        for(int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<Integer>();
        }

        for(int n : nums) {
            count.put(n,count.getOrDefault(n,0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;

        for(int i = freq.length - 1; i > 0 && index < k;i--) {
            for(int n : freq[i]) {
                res[index] = n;
                index++;
                if(index == k) {
                    break;
                }
            }
        }

        return res;
    }
}
