class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n=nums.length;
        List<String> ans=new ArrayList<>();
        int i=0,j=0;
        while(j<n){
            i=j;
            while(j<n-1 && nums[j+1]==nums[j]+1){
                j++;
            }
            StringBuilder str=new StringBuilder();
            if(j!=i){
                str.append(nums[i]).append("->").append(nums[j]);
            } else {
                str.append(nums[i]);
            }      
            ans.add(str.toString()); 
            j++;
        }
        return ans;
    }
}