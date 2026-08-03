class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(char ch : s.toCharArray())
        {
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else if(!stack.isEmpty() && stack.peek().equals(map.get(ch)))
                stack.pop();
            else
                return false;
        }
        return stack.isEmpty();
    }
}