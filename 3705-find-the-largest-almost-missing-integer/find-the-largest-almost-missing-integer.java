class Solution {
    public int largestInteger(int[] nums, int k) {
        int res=-1;
        if(nums.length==k){
            for(int i:nums)
                res=Math.max(res,i);
            return res;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int c=0;
        int left=0;
        for(int right=k-1;right<nums.length;right++)
        {
            c=left;
            while(c<=right){
                map.put(nums[c],map.getOrDefault(nums[c],0)+1);
                c++;
            }
            left++;
        }
        for(int i:nums){
            if(map.get(i)==1)
                res=Math.max(res,i);
        }
        return res;
    }
}