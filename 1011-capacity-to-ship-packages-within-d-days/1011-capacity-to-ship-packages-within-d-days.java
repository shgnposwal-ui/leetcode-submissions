class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        // Find minimum possible capacity
        // and maximum possible capacity
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                // This capacity works.
                // Try a smaller capacity.
                right = mid;
            } else {
                // This capacity is too small.
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canShip(int[] weights, int days, int capacity) {

        int daysUsed = 1;
        int currentWeight = 0;

        for (int weight : weights) {

            if (currentWeight + weight > capacity) {
                // Start a new day
                daysUsed++;
                currentWeight = weight;
            } else {
                currentWeight += weight;
            }

            if (daysUsed > days) {
                return false;
            }
        }

        return true;
    }
}