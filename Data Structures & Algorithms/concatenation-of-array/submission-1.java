class Solution {
    public int[] getConcatenation(int[] nums) {
        //base cases
        if(nums == null || nums.length ==0) {
            return nums;
        }
        int[] concatinatedArray = new int[nums.length*2];
        for(int i=0; i < nums.length; i++) {
            concatinatedArray[i] = nums[i];
            concatinatedArray[i+nums.length] = nums[i];
        }
        return concatinatedArray;
    }
}