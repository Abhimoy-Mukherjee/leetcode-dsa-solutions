class Solution {
    public int addDigits(int num) {
        if(num==0)
            return 0;
        return 1+addDigits((num-1)%9);
    }
}