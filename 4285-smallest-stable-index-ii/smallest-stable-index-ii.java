class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] suffixMin = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for(int i=nums.length-1; i>=0; i--){
            min = Math.min(min, nums[i]);
            suffixMin[i] = min;
        }

        int maxTillNow = 0;
        for(int i=0; i<nums.length; i++){
            maxTillNow = Math.max(maxTillNow, nums[i]);
            int score = maxTillNow - suffixMin[i];
            if(score<=k){
                return i;
            }
        }
        return -1;
    }
}