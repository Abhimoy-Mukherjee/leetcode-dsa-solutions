class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums)
            set.add(i);
        int i=1;
        for(i=1;i<=nums.length;i++)
        {
            if(!set.contains(k*i))
                return k*i;
        }
        return k*i;
    }
}