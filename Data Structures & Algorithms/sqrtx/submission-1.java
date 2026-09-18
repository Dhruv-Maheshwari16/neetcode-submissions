class Solution {
    public int mySqrt(int x) {
        
        int left = 1;
        int right = x;
        while(left <= right) {
            long mid = right - (right/2 - left/2);
            if((mid*mid) < x) {
                left = (int)mid + 1;
            }
            else if((mid*mid) > x) {
                right = (int)mid - 1;
            }
            else {
                return (int)mid;
            }
        }
        return right;
    }
}