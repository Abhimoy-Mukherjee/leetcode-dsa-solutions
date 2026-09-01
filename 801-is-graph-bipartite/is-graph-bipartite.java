class Solution {
    boolean res=true;
    public boolean isBipartite(int[][] graph) {
        int []colors=new int[graph.length];
        for(int i=0;i<colors.length;i++)
            colors[i]=-1;
        for(int i=0;i<graph.length;i++)
            if(colors[i]==-1)
                dfs(graph,i,0,colors);
        return res;
    }
    void dfs(int [][] graph,int node,int c,int []colors){
        colors[node]=c;
        for(int i=0;i<graph[node].length;i++)
        {
            int neigh=graph[node][i];
            if(colors[neigh]!=-1 && colors[neigh]==c)
                res=false;
            if(colors[neigh]==-1)
                dfs(graph,neigh,1-c,colors);
        }
    }
}