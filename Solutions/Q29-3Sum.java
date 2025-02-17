package Solutions;
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++)    
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int target=-nums[i];
            int left=i+1;
            int right=n-1;
            while(left<right){
                if(nums[left]+nums[right]>target)right--;
                else if(nums[left]+nums[right]<target)left++;
                else 
                {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left<n-1 && nums[left+1]==nums[left])left++;
                    while(right>0 && nums[right-1]==nums[right])right--;
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}