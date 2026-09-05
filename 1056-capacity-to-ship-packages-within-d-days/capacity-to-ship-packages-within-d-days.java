class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for(int w : weights){
            left = Math.max(left, w);
            right += w; 
        }

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