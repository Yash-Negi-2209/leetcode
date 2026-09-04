class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int size = Integer.MAX_VALUE; 
        int sum = 0;
        while(right<nums.length || sum>=target){
            if (sum>=target){
                sum -= nums[left];
                size = Math.min(size, right - left);
                left++;
                continue;
            }
            sum += nums[right];
            right++;
        }
        return size==Integer.MAX_VALUE? 0:size;
    }
}