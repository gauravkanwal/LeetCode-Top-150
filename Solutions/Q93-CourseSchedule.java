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

    