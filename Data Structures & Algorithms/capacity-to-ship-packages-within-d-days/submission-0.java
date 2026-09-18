class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int w : weights) {
            left = Math.max(left,w);
            right += w;
        }
        int result = 0;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int total = 0;
            int i = 0;
            while(i < weights.length) {
                int sum = 0;
                while(i < weights.length && weights[i] + sum <= mid) {
                    sum += weights[i];
                    i++;
                }
                total++;
            }
            if(total <= days) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return result;
    }
}