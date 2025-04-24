class Solution {
    public int longestConsecutive(int[] nums) {
        int ans=0;
        HashSet<Integer>set=new HashSet<>();
        
        for(int num:nums){
            set.add(num);
        }

        for(int num:set){
            if(set.contains(num-1)) continue;
            int count=0;
            int temp=num;
            while(set.contains(temp)){
                count++;
                temp++;
            }
            ans=Math.max(ans,count);
        }

        
        return ans;
    }
}