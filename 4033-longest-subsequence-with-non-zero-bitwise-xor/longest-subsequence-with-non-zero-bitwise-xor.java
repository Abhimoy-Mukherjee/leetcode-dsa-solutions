class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        int c=0;
        for(int i : nums){
            xor^=i;
            if(i==0)
                c++;
        }
        if(xor!=0)
            return nums.length;
        if(c==nums.length)
            return 0;
        return nums.length-1;
        
    }
}