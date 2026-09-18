/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left <= right) {
            int mid = right - (right/2 - left/2);
            switch (guess(mid)) {
                case 1:
                    left = mid + 1;
                    continue;
                case -1:
                    right = mid - 1;
                    continue;
                case 0:
                    return mid;
                default:
                    break;
            }
        }
        return -1;
    }
}