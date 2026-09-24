class Solution {
    public int smallestIndex(int[] nums) {
        int i;
        for(i=0;i<nums.length;i++)
        {
            int x=digitsum(nums[i]);
            if(i==x)
                break;
        }
        return i==nums.length?-1:i;
    }
    public int digitsum(int n){
        int p=0;
        while(n>0)
        {
            int d=n%10;
            p=p+d;
            n/=10;
        }
        return p;
    }
}