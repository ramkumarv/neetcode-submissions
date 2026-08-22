class Solution {
    public List<List<Integer>> permute(int[] nums) {

        //note first draw a diagram, starts with single input, 2 and then 2
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> curPerm = new ArrayList<>();
         permutationWithAllChoice(result, visited, curPerm, nums);
        //permutationByInserting(result, curPerm, 0, nums);
        System.out.println("results: " + result);
        return result;  

    }


    void permutationByInserting(List<List<Integer>> result, List<Integer> curPermutation, int curIndex, int[] nums) {

            if(curPermutation.size() == nums.length) {
                result.add(new ArrayList<>(curPermutation));
                return;
            }

            if(curIndex >= nums.length) {
                return;
            }

            int toBeAdded = nums[curIndex];        
            for(int i=0; i < curPermutation.size()+1; i++) {
                curPermutation.add(i, toBeAdded);
                permutationByInserting(result, curPermutation, curIndex+1, nums);       
                curPermutation.remove(i);
            }
            
    }

    void permutationWithAllChoice(List<List<Integer>> result, Set<Integer> visited, List<Integer> curPermutation, int[] nums) {
        
        //base case
         if(curPermutation.size() == nums.length) {
            result.add(new ArrayList<>(curPermutation));
            return;
         }   
        
         for(int curIdx =0; curIdx < nums.length;curIdx++) {
                if(!visited.contains(nums[curIdx])) {
                    visited.add(nums[curIdx]);
                    curPermutation.add(nums[curIdx]);
                    permutationWithAllChoice(result, visited, curPermutation, nums);
                    visited.remove(nums[curIdx]);
                    //the below will work but .remove(curPermutation.size()-1); is best becaue  if you remove the object is O(N) for a list.
                    curPermutation.remove(curPermutation.size()-1);
                    //curPermutation.remove(Integer.valueOf(nums[curIdx]));
                }
                
         }
    }    

    //this will not work
    void permute1(List<List<Integer>> result, Set<Integer> visited, List<Integer> curPerm, int curIndex, int[] nums) {
        
        if(curIndex == nums.length && curPerm.size() >0) {
            result.add(new ArrayList<>(curPerm));
            return;
        }

        if(curIndex >= nums.length) {
            return;
        }
        if(visited.contains(nums[curIndex])) {
            return;
        }

        visited.add(nums[curIndex]);
        curPerm.add(nums[curIndex]);
        permute1(result, visited, curPerm, curIndex+1, nums);
        visited.remove(nums[curIndex]);
        curPerm.remove(curPerm.size() -1 );
        //permute(result, visited, curPerm, curIndex+1, nums);


    }

       



}
