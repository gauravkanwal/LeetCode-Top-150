class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int compliment=target-nums[i];
            if(map.containsKey(compliment)){
                return new int [] {i,map.get(compliment)};
                }
            map.put(nums[i],i);
            }        
         return new int[2];
        }
}
