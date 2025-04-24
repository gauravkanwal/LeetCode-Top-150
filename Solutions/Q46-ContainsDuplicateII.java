
//hashmap approach:
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap <Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i]) && i-map.get(nums[i])<=k) return true;
            map.put(nums[i],i);
        }
        return false;
    }
}

//hashset approach:
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashSet <Integer> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
           if(i>k){
            set.remove(nums[i-k-1]);
           }
           if(set.contains(nums[i])) return true;
           set.add(nums[i]);
        }
        return false;
    }
}