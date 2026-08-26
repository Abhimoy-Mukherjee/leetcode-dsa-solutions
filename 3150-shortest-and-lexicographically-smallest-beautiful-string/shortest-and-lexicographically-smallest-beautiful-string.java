class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String res ="";
        int left=0;
        int c=0;
        for (int right=0;right<s.length();right++) {
            if (s.charAt(right)=='1')
                c++;
            while (c==k) {
                while (left<=right && s.charAt(left)=='0')
                    left++;
                String curr=s.substring(left,right+1);
                if (res.equals("") || curr.length()<res.length() || (curr.length()==res.length() && curr.compareTo(res)<0))
                    res=curr;
                if (s.charAt(left)=='1')
                    c--;
                left++;
            }
        }
        return res;
    }
}