public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q=new LinkedList<>();
        boolean[] visited=new boolean[bank.length];
        q.offer(startGene);
        int count=0;

        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                String s=q.poll();
                if(s.equals(endGene)) return count;
                for(int i=0;i<bank.length;i++){
                    if(visited[i]) continue;
                    if(isMutation(s,bank[i])){ 
                        q.offer(bank[i]);
                        visited[i]=true;
                    }
                }
            }
            count++;
        }

        return -1;
    }

    private boolean isMutation(String s, String m){
        int count=0;
        for(int i=0;i<8;i++){
            if(s.charAt(i)!=m.charAt(i)){
                count++;
                if(count>1) return false;
            }
        }
        return count==1;
    }
} {
    
}
