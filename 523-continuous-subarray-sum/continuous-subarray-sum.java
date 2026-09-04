class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderIndex = new HashMap<>();
        int prefixSum = 0;
        remainderIndex.put(0,-1);
        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            int remainder = prefixSum%k;
            if(remainderIndex.containsKey(remainder)){
                if (i-remainderIndex.get(remainder)>=2){
                    return true;
                }
            }
            else{
                remainderIndex.put(remainder, i);
            }
        }
        return false;
    }
}