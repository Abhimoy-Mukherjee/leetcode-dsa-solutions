class Solution {
    public int minimumDeletions(int[] nums) {
        int min=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[min])
                min=i;
            if(nums[i]>nums[max])
                max=i;
        }
        int left=Math.min(min,max);
        int right=Math.max(min,max);
        int f=right+1;
        int b=nums.length-left;
        int r=(left+1)+(nums.length-right);
        return Math.min(f, Math.min(b,r));
    }
}