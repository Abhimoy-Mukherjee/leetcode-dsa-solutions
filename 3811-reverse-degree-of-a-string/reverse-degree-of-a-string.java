class Solution {
    public int reverseDegree(String s) {
        int res=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            res+=(123-ch)*(i+1);
        }
        return res;
    }
}