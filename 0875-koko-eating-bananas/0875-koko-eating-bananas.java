class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find maximum pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                // mid works, try a smaller speed
                right = mid;
            } else {
                // mid doesn't work, need a faster speed
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int h, int k) {

        long hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k;

            if (hours > h) {
                return false;
            }
        }

        return true;
    }
}