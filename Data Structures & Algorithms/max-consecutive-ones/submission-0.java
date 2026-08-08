class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCountSeen = 0;
        int currCount = 0;
        for(int i = 0; i<nums.length;i++) {
            if(nums[i] == 1) {
                currCount++;
            } else {
                maxCountSeen = Math.max(currCount, maxCountSeen);
                currCount=0;
            }
        }
        maxCountSeen = Math.max(currCount, maxCountSeen);
        return maxCountSeen;
    }
}