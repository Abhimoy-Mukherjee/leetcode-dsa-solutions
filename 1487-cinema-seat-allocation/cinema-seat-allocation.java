class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,Set<Integer>> map=new HashMap<>();
        for(int x[]:reservedSeats){
            int row=x[0],seat=x[1];
            if(!map.containsKey(row))
            map.put(row,new HashSet<>());
            map.get(row).add(seat);
        }
        int res=(n-map.size())*2;
        for(Set<Integer> set:map.values()){
            boolean a=!set.contains(2)&&!set.contains(3)&&!set.contains(4)&&!set.contains(5);
            boolean b=!set.contains(4)&&!set.contains(5)&&!set.contains(6)&&!set.contains(7);
            boolean c=!set.contains(6)&&!set.contains(7)&&!set.contains(8)&&!set.contains(9);
            if(a&&c)
            res+=2;
            else if(a||b||c)
            res+=1;
            else
            res+=0;
        }
        return res;
    }
}