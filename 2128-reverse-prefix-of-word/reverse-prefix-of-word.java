class Solution {
    public String reversePrefix(String word, char ch) {
            Deque<Character> stack = new ArrayDeque<>();
            String s="";
            boolean found =false;
        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)!=ch)
                stack.push(word.charAt(i));
            else{
                stack.push(word.charAt(i));
                s=word.substring(i+1);
                found=true;
                break;
            }
        }
        if(!found)
            return word;
        while(!stack.isEmpty())
            s=stack.removeLast()+s;
        return s;
    }
}