class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        boolean[] contains = new boolean[101];
        List<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            min = Math.min(num, min);
            max = Math.max(num, max);
            contains[num] = true;
        }
        for(int i=min; i<=max; i++){
            if (!contains[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}