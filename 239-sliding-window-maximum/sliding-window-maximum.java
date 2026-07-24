class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int i=0;
        while(i<nums.length)
        {
            while(!deque.isEmpty() && nums[i]>nums[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);
            if(deque.peekFirst() <= i-k)
                deque.removeFirst();
            if(i>=k-1)
                list.add(nums[deque.peekFirst()]);
            i++;
        }
        int []res = new int[list.size()];
        for(int j=0;j<list.size();j++)
            res[j]=list.get(j);

        return res;
    }
}