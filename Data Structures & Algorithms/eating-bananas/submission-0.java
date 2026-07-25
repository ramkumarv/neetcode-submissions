class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // we want min k (eating rate per hour)
        //also another key is piles.length <= h <= 1,000,000 which states that 
        //if piles.length =1, then it will take atlest 1 hr 
        //piles.length =2, then min hr =2 but this value is given by the problem statement

        int left = 1;
        int right = -1;
        for(int i = 0; i < piles.length; i++){
            right = Math.max(right, piles[i]);
        }
        int rate = right; 
        while(left <= right) {
            int mid = left + (right - left)/2;
            int hours = noOfHoursRequired(mid, piles);
            if(hours <= h) {
                rate = Math.min(rate , mid);
                right = mid -1;
            } else {
                left = mid +1;
            }
        }    
        return rate;
    }

    int noOfHoursRequired(int noOfBannans, int[] piles) {
        int hours = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] < noOfBannans) {
                hours = hours +1;
            } else if(piles[i] % noOfBannans == 0) {
                hours = hours + piles[i] / noOfBannans;
            } else {
                hours = hours + 1 + piles[i] / noOfBannans;
            }
        }
        return hours;
    }

    
}
