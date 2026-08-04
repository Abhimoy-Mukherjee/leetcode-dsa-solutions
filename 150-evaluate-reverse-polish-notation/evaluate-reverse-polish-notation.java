class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String val : tokens)
        {
            if(val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/"))
                stack.push(calculate(val.charAt(0), stack.pop(),stack.pop()));
            else
                stack.push(Integer.parseInt(val));
        }
        return stack.peek();
    }
    public int calculate(char op, int b, int a){
        int result;
        result = switch(op)
        {
            case '+' -> a+b;
            case '-' -> a-b;
            case '*' -> a*b;
            default -> a/b;
        };
        return result;
    }
}