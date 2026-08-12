class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        
        for(int i=0; i<n; i++){
            
                 while(!stack.isEmpty()&& temperatures[i]>temperatures[stack.peek()]){

                    int previousIndex= stack.pop();
                    ans[previousIndex]= i-previousIndex;
                 }
            
            stack.push(i);
           
        }
        return ans;
        
    }
}