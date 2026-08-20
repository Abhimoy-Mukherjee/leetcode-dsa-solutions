class Solution {
    public int[] resultArray(int[] nums) {
        Deque<Integer> q1=new ArrayDeque<>();
        Deque<Integer> q2=new ArrayDeque<>();
        q1.addFirst(nums[0]);
        q2.addFirst(nums[1]);
        for(int i=2;i<nums.length;i++)
        {
            if(q1.peekFirst()>q2.peekFirst())
                q1.addFirst(nums[i]);
            else
                q2.addFirst(nums[i]);
        }
        int []arr=new int[nums.length];
        int c=0;
        while(!q1.isEmpty())
        {
            arr[c]=q1.removeLast();
            c++;
        }
        while(!q2.isEmpty())
        {
            arr[c]=q2.removeLast();
            c++;
        }
        return arr;
    }
}