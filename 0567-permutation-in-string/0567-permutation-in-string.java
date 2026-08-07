class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Frequency of characters in s1
        for (char ch : s1.toCharArray()) {
            count1[ch - 'a']++;
        }

        int windowSize = s1.length();

        // First window of s2
        for (int i = 0; i < windowSize; i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(count1, count2)) {
            return true;
        }

        // Slide the window
        for (int i = windowSize; i < s2.length(); i++) {

            // Add new character
            count2[s2.charAt(i) - 'a']++;

            // Remove old character
            count2[s2.charAt(i - windowSize) - 'a']--;

            // Check if frequencies match
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }
}