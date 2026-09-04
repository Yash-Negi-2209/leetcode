class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        long currSum = 0, maxSum = 0;
        while(right<nums.length){
            if(set.contains(nums[right]) || set.size()==k){
                set.remove(nums[left]);
                currSum -= nums[left];
                left++;
                continue;
            }
            set.add(nums[right]);
            currSum += nums[right];
            if(set.size()==k){
                maxSum = Math.max(maxSum, currSum);
            }
            right++;
        }
        return maxSum;
    }
}