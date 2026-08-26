class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start < end) {
            swap(s,start++,end--);
        }
    }

    private void swap(char[] s,int index1,int index2) {
        char temp = s[index2];
        s[index2] = s[index1];
        s[index1] = temp;
    }
}