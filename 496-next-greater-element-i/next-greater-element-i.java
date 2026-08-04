class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int []arr=new int[nums1.length];
        for(int i=0;i<nums2.length;i++)
        {
            while(!stack.isEmpty() && nums2[i]>nums2[stack.peek()])
            {
                map.put(nums2[stack.peek()],nums2[i]);
                stack.pop();
            }
            stack.push(i);
        }
        int k=0;
        for(int i:nums1)
        {
            if(map.containsKey(i))
                arr[k]=map.get(i);
            else
                arr[k]=-1;
            k++;
        }
        return arr;
    }
}