class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            prefixProduct[i] = 1;
            suffixProduct[i] = 1;
        }
        int prefix = 1;
        for(int i = 1; i < nums.length;i++) {
            prefix *= nums[i - 1];
            prefixProduct[i] = prefix;
        }

        int suffix = 1;

        for(int i = nums.length - 2;i >= 0;i--) {
            suffix *= nums[i + 1];
            suffixProduct[i] = suffix;
        }
        int[] result = new int[nums.length]; 

        for(int i = 0; i < nums.length ; i++) {
            result[i] = prefixProduct[i]*suffixProduct[i];
        }

        return (result);
    }
}  
