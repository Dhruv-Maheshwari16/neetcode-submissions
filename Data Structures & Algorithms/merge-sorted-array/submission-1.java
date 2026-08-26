class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int left = 0;
        int right = 0;
        int i = 0;
        while(left < m && right < n) {
            if(nums1[left] <= nums2[right]) {
                res[i++] = nums1[left++];
            }
            else {
                res[i++] = nums2[right++];
            }
        }

        while(left < m) {
            res[i++] = nums1[left++];
        }

        while(right < n) {
            res[i++] = nums2[right++];
        }

        for(int j = 0;j < m+n;j++) {
            nums1[j] = res[j];
        }
    }
}