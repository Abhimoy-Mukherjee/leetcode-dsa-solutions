class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int []result = new int[temp.length];
        int k=0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<temp.length;i++)
        {
            while(!stack.isEmpty() && temp[i] > temp[stack.peek()])
            {
                int index=stack.peek();
                result[index]=i-index;
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}