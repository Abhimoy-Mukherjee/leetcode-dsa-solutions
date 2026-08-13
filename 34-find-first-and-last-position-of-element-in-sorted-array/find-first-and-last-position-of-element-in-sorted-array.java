class Solution {
    public int[] searchRange(int[] nums, int target) {
        // do binary search chalana hai ek se first occurance
        // aayega aur dusre wale se last occurance
        // total time compl. O(logn) hoga, O(logn)+O(logn)=O(2logn)
        int start=0;
        int end=nums.length-1;
        int index1=-1,index2=-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]>target)
                end=mid-1;
            else if(nums[mid]<target)
                start=mid+1;
            else{
                index1=mid;
                end=mid-1;
            }
        }
        start=0;
        end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]>target)
                end=mid-1;
            else if(nums[mid]<target)
                start=mid+1;
            else{
                index2=mid;
                start=mid+1;
            }
        }
        return new int[]{index1,index2};
    }
}