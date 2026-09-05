class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int[] suffixMin = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            min = Math.min(min, nums[i]);
            suffixMin[i] = min;
        }

        int currMax = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            currMax = Math.max(currMax, nums[i]);
            if ((currMax - suffixMin[i])<=k){
                return i;
            }
        }
        return -1;
    }
}