class Solution {
    public boolean stoneGameIX(int[] stones) {
        if(stones.length==1)
            return false;
        int []arr=new int[3];
        for(int i:stones)
        {
            if(i%3==0)
                arr[0]+=1;
            else if(i%3==1)
                arr[1]+=1;
            else
                arr[2]+=1;
        }
        if(arr[0]%2==0)
            return arr[1]>0 && arr[2]>0;
        return Math.abs(arr[1]-arr[2])>2;
    }
}