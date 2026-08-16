class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curSet = new ArrayList<>();
        combinationR(n,result, curSet, k, 1);
        return result;
    }

    void combinationR(int n,List<List<Integer>> result, List<Integer> curSet, int k, int curNumber){
        //collect the result
        if(curSet.size() == k) {
            result.add(new ArrayList<>(curSet));
            return;
        }

        if(curNumber > n) {
            return;
        }

        curSet.add(curNumber);
        combinationR(n, result, curSet, k, curNumber+1);
        curSet.remove(curSet.size()-1);
        combinationR(n, result, curSet, k, curNumber+1);
    }
}