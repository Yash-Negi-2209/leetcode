class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);  // empty prefix (sum 0) occurs once, before we start

        int currSum = 0;
        int count = 0;

        for (int num : nums) {
            currSum += num;

            // if (currSum - k) has appeared before, those are valid subarrays ending here
            if (prefixCount.containsKey(currSum - k)) {
                count += prefixCount.get(currSum - k);
            }

            // record this prefix sum
            prefixCount.put(currSum, prefixCount.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}