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