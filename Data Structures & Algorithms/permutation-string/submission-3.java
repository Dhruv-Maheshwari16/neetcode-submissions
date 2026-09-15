class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] hashcode = new int[26];
        int[] test_hash = new int[26];

        int len = s1.length();

        // Frequency of s1
        for (int i = 0; i < len; i++) {
            hashcode[s1.charAt(i) - 'a']++;
            test_hash[s2.charAt(i) - 'a']++;
        }

        // Compare first window
        if (Arrays.equals(hashcode, test_hash)) {
            return true;
        }

        // Sliding window
        int i = len;

        while (i < s2.length()) {

            // Remove character leaving window
            test_hash[s2.charAt(i - len) - 'a']--;

            // Add new character
            test_hash[s2.charAt(i) - 'a']++;

            if (Arrays.equals(hashcode, test_hash)) {
                return true;
            }

            i++;
        }

        return false;
    }
}