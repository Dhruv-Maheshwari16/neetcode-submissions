/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int max = maximum(mountainArr,0,n-1);

        if(target > mountainArr.get(max)) {
            return -1;
        }

        if(target == mountainArr.get(max)) {
            return max;
        }

        int low1 = 0;
        int high1 = max - 1;
        int low2 = max + 1;
        int high2 = n - 1;

        while(low1 <= high1) {
            int mid1 = low1 + (high1 - low1)/2;
            int temp = mountainArr.get(mid1);
            if(target > temp) {
                low1 = mid1 + 1;
            }
            else if(target < temp) {
                high1 = mid1 - 1;
            }
            else {
                return mid1;
            }
        }

        while(low2 <= high2) {
            int mid2 = low2 + (high2 - low2)/2;
            int temp = mountainArr.get(mid2);
            if(target > temp) {
                high2 = mid2 - 1;
            }
            else if(target < temp) {
                low2 = mid2 + 1;
            }
            else {
                return mid2;
            }
        }
        return -1;
    }

    private int maximum(MountainArray arr,int left,int right) {
        int index = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int max = arr.get(mid);
            if(mid < arr.length() - 1 && max < arr.get(mid + 1)) {
                left = mid + 1;
            }
            else if(mid > 0 && max < arr.get(mid - 1)) {
                right = mid - 1;
            }
            else {
                return mid;
            }
        }
        return index;
    }
}