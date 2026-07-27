class Solution {
    public int[] sortArray(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        quickSort(nums,low,high);

        return nums;
    }

    public int partition(int[] nums,int low,int high) {
        int pivot = nums[low];
        int i = low+1;
        int j = high;
        while(i <= j) {
            while(i <= high && nums[i] <= pivot) {
                i++;
            }
            while(j >= low && nums[j] > pivot) {
                j--;
            }
            if(i < j) {
                swap(nums,i,j);
            }
        }
        swap(nums,low,j);
        return j;
    }

    public void swap(int[] nums,int a,int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }

    public void quickSort(int[] nums,int low,int high) {
        if(low >= high) {
            return;
        }
        int j = partition(nums,low,high);
        quickSort(nums,low,j-1);
        quickSort(nums,j+1,high);
    }
}