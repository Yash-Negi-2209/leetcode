class Solution {
    public int pivotIndex(int[] nums) {
        int[] leftprefix = new int[nums.length];
        int[] rightprefix = new int[nums.length];
        leftprefix[0] = nums[0]; 
        rightprefix[nums.length-1] = nums[nums.length-1];
        for(int i=1; i<nums.length; i++){
            leftprefix[i] = leftprefix[i-1] + nums[i];
            rightprefix[nums.length-1-i] = rightprefix[nums.length-1-i+1] + nums[nums.length-1-i];
        }
        for(int i=0; i<nums.length; i++){
            if (leftprefix[i]==rightprefix[i]){
                return i;
            }
        }
        return -1;
    }
}