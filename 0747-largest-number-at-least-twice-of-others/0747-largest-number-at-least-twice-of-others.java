class Solution {
    public int dominantIndex(int[] nums) {

        // If there is only one element,
        // it is automatically the largest number.
        if (nums.length == 1) {
            return 0;
        }

        int largest = -1;
        int secondLargest = -1;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > largest) {

                // Current largest becomes second largest
                secondLargest = largest;

                // Update largest
                largest = nums[i];

                // Store index of largest
                index = i;

            } else if (nums[i] > secondLargest) {

                // Update second largest
                secondLargest = nums[i];
            }
        }

        // Check whether largest is at least twice
        // the second largest
        if (largest >= 2 * secondLargest) {
            return index;
        }

        return -1;
    }
}