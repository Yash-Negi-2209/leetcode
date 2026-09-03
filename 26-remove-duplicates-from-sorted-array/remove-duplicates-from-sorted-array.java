class Solution {
    public int removeDuplicates(int[] nums) {
        int parent = 0;
        int child = parent+1;
        while(child < nums.length){
            if (nums[parent]==nums[child]){
                child++;
            }
            else{
                parent++;
                nums[parent] = nums[child];
                child++;
            }
        }
        return parent+1;
    }
}