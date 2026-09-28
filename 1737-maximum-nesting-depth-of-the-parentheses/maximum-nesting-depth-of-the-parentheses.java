class Solution {
    public int maxDepth(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        int res=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
                stack.push(ch);
            else if(ch==')'){
                res=Math.max(res,stack.size());
                stack.pop();
            }
        }
        return res;
    }
}