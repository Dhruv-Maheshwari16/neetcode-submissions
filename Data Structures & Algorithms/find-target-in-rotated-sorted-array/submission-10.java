class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(nums[mid] < nums[right]) {
                if(target > nums[mid]) {
                    if(target < nums[right]) {
                        left = mid + 1;
                    }
                    else if(target > nums[right]) {
                        right = mid - 1;
                    }
                    else {
                        return right;
                    }
                }
                else if(target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    return mid;
                }
            }

            else{
                if(target < nums[mid]) {
                    if(target > nums[right]) {
                        right = mid - 1;
                    }
                    else if(target < nums[right]) {
                        left = mid + 1;
                    }
                    else {
                        return right;
                    }
                }
                else if(target > nums[mid]) {
                    left = mid + 1;
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
