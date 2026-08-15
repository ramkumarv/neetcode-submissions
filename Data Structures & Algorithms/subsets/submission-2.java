class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        int[] currSubSet = new int[0];
        subsetR(nums, results, currSubSet, 0);
        return results;
    }

    void subsetR(int[] nums, List<List<Integer>> results, int[] currSubSet, int curIndex) {
        if(curIndex >= nums.length) {
            results.add(Arrays.stream(currSubSet)
                           .boxed()
                           .collect(Collectors.toList()));
            return;
        }
        //O(n^2 * 2^n) - this is not required. everytime    currSubSet
        //first use an object ArrayList intead of an array and reuse    them
        //then prune once stack is returned 
        int[] included = Arrays.copyOf(currSubSet, currSubSet.length+1);
        included[included.length - 1 ]= nums[curIndex];
        subsetR(nums, results, included, curIndex + 1);
        subsetR(nums, results, currSubSet, curIndex + 1);
    }
}