class Solution {
    public boolean checkDivisibility(int n) {
        int p=0,d=1;
        int x=n;
        while(x>0)
        {
            int r=x%10;
            p+=r;
            d*=r;
            x/=10;
        }
        return (n%(p+d)==0);
    }
}