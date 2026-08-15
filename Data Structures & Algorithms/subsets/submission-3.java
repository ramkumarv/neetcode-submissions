class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> currSubSet = new ArrayList<>();
        subsetR(nums, results, currSubSet, 0);
        return results;
    }

    void subsetR(int[] nums, List<List<Integer>> results, List<Integer> currSubSet, int curIndex) {
        if(curIndex >= nums.length) {
            results.add(new ArrayList<>(currSubSet));
            return;
        }
        currSubSet.add(nums[curIndex]);
        subsetR(nums, results, currSubSet, curIndex + 1);
        System.out.println(currSubSet.size() + ":" +curIndex);
        currSubSet.remove(currSubSet.size()-1);
        subsetR(nums, results, currSubSet, curIndex + 1);
    }
}