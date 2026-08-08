class Solution {
    public int calPoints(String[] operations) {
        Stack<String> op = new Stack<>();
        for(int i =0; i < operations.length;i++) {
            if(operations[i].equals("C")) {
                op.pop();
            }else if(operations[i].equals("D")) {
                Integer doubleVal = Integer.valueOf(op.peek())*2;
                op.push(String.valueOf(doubleVal));    
            } else if(operations[i].equals("+")) {
                Integer first = Integer.valueOf(op.pop());
                Integer second = Integer.valueOf(op.pop());
                Integer ans = first+second;
                op.push(second.toString());
                op.push(first.toString());
                op.push(ans.toString());
            } else {
                op.add(Integer.valueOf(operations[i]).toString());
            }
        }

        int ans = 0;
        while(!op.isEmpty()) {
           ans = ans + Integer.valueOf(op.pop());     
        }
        return ans;
    }
}