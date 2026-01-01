//DFS:
class Solution {
    List<Integer> [] neighbours;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        neighbours=new List[numCourses];
        //initializing each index with an empty arraylist:
        for(int i=0;i<numCourses;i++){
            neighbours[i]=new ArrayList<>();
        }
        
        //building graph / adding neighbours
        for(int i=0;i<prerequisites.length;i++){
            neighbours[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        //checking for cycle in the graph and also sorting in topological order using stack together
        boolean[] visited=new boolean[numCourses];
        boolean[] recPath=new boolean[numCourses];
        Stack<Integer> st=new Stack<>();
        int[] res=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(checkCycleAndTopologicalSort(i,visited,recPath,st)) return new int [0];
            }
        }


        //filling result arr;
        for(int i=0;i<numCourses;i++){
            res[i]=st.pop();
        }        

        return res;


    }

    private boolean checkCycleAndTopologicalSort(int node,boolean[] visited, boolean[] recPath,Stack<Integer> stack){
        visited[node]=true;
        recPath[node]=true;
        for(int neigh:neighbours[node]){
            if(!visited[neigh]){
                if(checkCycleAndTopologicalSort(neigh,visited,recPath,stack)) return true;
            }
            else if(recPath[neigh]) return true;
        }
        recPath[node]=false;
        stack.push(node);
        return false;
    }

}


//BFS (Khan's Algorithm):
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> [] l=new List[numCourses];
        
        //initializing each index with empty list
        for(int i=0;i<numCourses;i++){
            l[i]= new ArrayList<>();
        }

        //adding neighbours and peroforming khan's algorithm:
        int[] indegree=new int[numCourses];
        for(int[] p:prerequisites){
            l[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
           if(indegree[i]==0){
            q.offer(i);
           }
        }

        int [] res=new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int f=q.poll();
            res[index++]=f;
            for(int neigh:l[f]){
                indegree[neigh]--;
                if(indegree[neigh]==0) q.offer(neigh);
            }
        }

        return index==numCourses?res:new int[0];
    }
}