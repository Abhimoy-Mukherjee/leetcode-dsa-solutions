class Solution {
    public int countDigits(int num) {
        int res=0;
        int temp=num;
        while(temp>0)
        {
            int p=temp%10;
            if(num%p==0)
                res++;
            temp/=10;
        }
        return res;
    }
}