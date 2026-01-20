class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(res,nums,new boolean[nums.length],new ArrayList<Integer>());
        return res;
    }
    private void backtrack(List<List<Integer>> res,int[] nums,boolean[] visited,List<Integer> list){

        if(list.size()==nums.length){
            res.add(new ArrayList(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            visited[i]=true;
            list.add(nums[i]);
            backtrack(res,nums,visited,list);
            list.remove(list.size()-1);
            visited[i]=false;
        }
    }
}