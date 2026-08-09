class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s : words)
            map.put(s,map.getOrDefault(s,0)+1);
        List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue()))
                return b.getValue() - a.getValue();
            return a.getKey().compareTo(b.getKey());
        });
        List<String> ls = new ArrayList<>();
        for(int i = 0;i<k;i++)
         ls.add(list.get(i).getKey());
        return ls;
    }
}