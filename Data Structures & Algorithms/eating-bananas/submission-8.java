class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for(int pile : piles) {
            right = Math.max(right,pile);
        }
        int result = Integer.MAX_VALUE;
        while(left <= right) {
            int sum = 0;
            int mid = right - (right/2 - left/2);

            for(int i = 0;i < piles.length;i++) {
                sum += (piles[i] + mid - 1)/mid;
            }
            if(sum > h) {
                left = mid + 1;
            }
            else {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }
}
