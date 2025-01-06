package Solutions;
import java.util.*;

//solution:
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int majority=(n/2)+1;
        int res=-1;
        for(int i=0;i<=n-majority;i++)
        {
            if(nums[i]==nums[i+majority-1])
            {
                res=nums[i];
                break;
            }
        }
        return res;
    }
}