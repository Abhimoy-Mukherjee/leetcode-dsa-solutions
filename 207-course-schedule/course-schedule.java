class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int []indeg=new int[numCourses];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int src=prerequisites[i][0];
            int des=prerequisites[i][1];
            adj.get(des).add(src);
            indeg[src]++;
        }
        int c=0;
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(indeg[i]==0)
                q.offer(i);
        while(!q.isEmpty())
        {
            int course=q.poll();
            c++;
            for(int next:adj.get(course)){
                indeg[next]--;
                if(indeg[next]==0)
                    q.offer(next);
            }
        }
        return c==numCourses;
    }
}