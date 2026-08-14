class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map =new HashMap<>();
        int left=0;
        int res=0;
        for(int right=0;right<s.length();right++)
        {
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>2)
            {
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}