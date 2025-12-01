class Solution {
    HashMap <String, HashMap<String,Double>> adj;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        adj=new HashMap<>();
        double [] ans= new double[queries.size()];
        //filling the adajency list
        for(int i=0;i<equations.size();i++){
            String u=equations.get(i).get(0);
            String v=equations.get(i).get(1);
            double value=values[i];

            adj.putIfAbsent(u,new HashMap<>());
            adj.putIfAbsent(v,new HashMap<>());

            adj.get(u).put(v,value);
            adj.get(v).put(u,1/value);
        }

        //finding the solution to every query now:
        int i=0;
        for(List<String> query :queries){
            String u=query.get(0);
            String v=query.get(1);

            HashSet <String> visited= new HashSet<>();
            ans[i] =dfs(u,v,visited);
            i++;
        }
        return ans;
    }

    public double dfs(String u, String v, HashSet<String>visited){
        if(!adj.containsKey(u) || !adj.containsKey(v)) return -1.0;
        if(u.equals(v)) return 1.0;

        visited.add(u);

        
        for(String neighbour:adj.get(u).keySet())
        {   if(visited.contains(neighbour)) continue;

            Double res= dfs(neighbour,v,visited);
            if(res!=-1.0){
                return res*adj.get(u).get(neighbour);
            }
        }

        return -1.0;
    }
}