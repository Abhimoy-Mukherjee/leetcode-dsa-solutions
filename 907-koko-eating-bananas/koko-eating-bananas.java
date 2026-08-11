class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=piles[0];
        for(int i=1;i<piles.length;i++)
            if(piles[i]>high)
                high=piles[i];
        while(low<high){
            int guess = low +(high-low)/2;
            int hours = checkHours(piles, guess);
            if(hours>h)
                low=guess+1;
            else
                high=guess;
        }
        return low;
    }
    public int checkHours(int []piles, int speed){
        int hours=0;
        for(int i=0;i<piles.length;i++)
        {
            hours = hours+ piles[i]/speed;
            if(piles[i]%speed!=0)
                hours++;
        }
        return hours;
    }
}