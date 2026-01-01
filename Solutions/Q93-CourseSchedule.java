//DFS:

class Solution {
    HashMap<Integer,List<Integer>> neighbours;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        neighbours=new HashMap<>();

        // adding neighbours
        for(int i=0;i<prerequisites.length;i++){
            List<Integer> l= neighbours.getOrDefault(prerequisites[i][0],new ArrayList<>());
            l.add(prerequisites[i][1]);
            neighbours.put(prerequisites[i][0],l);
        }


        HashMap<Integer,Boolean> visited= new HashMap<>();
        HashMap<Integer,Boolean> recPath= new HashMap<>();

        //checking cycle from every node
        for(int i: neighbours.keySet()){
            if(!visited.getOrDefault(i,false)){
                if(isCycleDirectedDFS(i,visited,recPath)) return false;
            }
        }

        return true;
    }

    private boolean isCycleDirectedDFS(int node,HashMap<Integer,Boolean> visited,HashMap<Integer,Boolean> recPath){
        visited.put(node,true);
        recPath.put(node,true);

        for(int neigh:neighbours.getOrDefault(node,new ArrayList<Integer>())){
            if(!visited.getOrDefault(neigh,false)){
                if(isCycleDirectedDFS(neigh,visited,recPath)) return true;
            }else if(recPath.getOrDefault(neigh,false)) return true;
        }

        recPath.put(node,false);
        return false;
    }
}

//BFS (Khan's Algorithm):
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int count=0;

        while(!q.isEmpty()){
            int f=q.poll();
            count++;
            for(int neigh:l[f]){
                indegree[neigh]--;
                if(indegree[neigh]==0) q.offer(neigh);
            }
        }

        return count==numCourses;
    }
}
    