class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < k;i++) {
            result.add(i,arr[i]);
        }

        int i = k;
        while(i < arr.length) {
            int temp = result.get(0);
            if(Math.abs(temp - x) > Math.abs(arr[i] - x)) {
                result.remove(0);
                result.add(k-1,arr[i]);
            }
            i++;
        }

        return result;
    }
}