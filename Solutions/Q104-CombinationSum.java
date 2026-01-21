class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(res,candidates,target,new ArrayList<>(),0,0);
        return res;
    }

    private void backtrack(List<List<Integer>> res,int[] candidates, int target,List<Integer> list,int sum,int idx)
    {
        if(sum==target){
            res.add(new ArrayList(list));
            return;
        }

        if(sum>target) return;

        for(int i=idx;i<candidates.length;i++){
            int num=candidates[i];
            list.add(num);
            backtrack(res,candidates,target,list,sum+candidates[i],i);
            list.remove(list.size()-1);
        }
    }
}