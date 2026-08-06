class Solution {
    public int mySqrt(int x) {
        if(x<2)
            return x;
        long low=1;
        long high=x/2;
        while(low<=high)
        {
            long mid = low+(high-low)/2;
            long sq=mid*mid;
            if(sq==x)
                return (int)mid;
            else if(sq>x)
                high=mid-1;
            else
                low=mid+1;
        }
        return (int)high;
    }
}