class Solution {
    public String reverseWords(String s) {
        int left=0;
        String sarr[]=s.trim().split("\\s+");
        int right=sarr.length-1;
        while(left<=right){
            String temp=sarr[left];
            sarr[left]=sarr[right];
            sarr[right]=temp;
            left++;
            right--;
        }
        return String.join(" ",sarr);
    }
}