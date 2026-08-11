class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=weights[0];
        int high=0;
        for(int i=0;i<weights.length;i++)
        {
            if(weights[i]>low)
                low=weights[i];
            high+=weights[i];
        }
        while(low<high){
            int guess=low+(high-low)/2;
            int day = curCapacity(weights, guess);
            if(day>days)
                low=guess+1;
            else
                high=guess;
        }
        return low;
    }
    public int curCapacity(int []weights,int guess){
        int capacity = 0;
        int days=1;
        for(int i=0;i<weights.length;i++)
        {
            if(capacity+weights[i]>guess)
            {
                days++;
                capacity=weights[i];
            }
            else
                capacity+=weights[i];
        }
        return days;
    }
}