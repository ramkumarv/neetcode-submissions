class Solution {
    public int climbStairs(int n) {
        return totolNoOfWaysToClaimb(n, 0, new HashMap<Integer, Integer>());
    }


    int totolNoOfWaysToClaimb(int totalNoSteps, int curStep, Map<Integer, Integer> cache) {
        if(curStep == totalNoSteps) {
            return 1;
        }

        if(curStep > totalNoSteps) {
            return 0;
        }
        if(cache.get(curStep) != null) {
            return cache.get(curStep); 
        }
        int oneStep = totolNoOfWaysToClaimb(totalNoSteps, curStep + 1, cache);
        int twoStep = totolNoOfWaysToClaimb(totalNoSteps, curStep + 2, cache);
        cache.put(curStep, oneStep+twoStep);
        return oneStep+twoStep;
    }
}
