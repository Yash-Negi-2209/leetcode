class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = maxWeight(weights);
        int right = sumWeights(weights);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int maxWeight(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int w : weights) {
            max = Math.max(max, w);
        }
        return max;
    }

    public int sumWeights(int[] weights) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        return sum;
    }

    public boolean canShip(int[] weights, int days, int capacity) {
        int dayCount = 1;
        int maxLoadinDay = 0;
        for (int w : weights) {
            if (maxLoadinDay + w > capacity) {
                dayCount++;
                maxLoadinDay = 0;
            }
            maxLoadinDay += w;
            if (dayCount > days) {
                return false;
            }
        }
        return true;
    }
}