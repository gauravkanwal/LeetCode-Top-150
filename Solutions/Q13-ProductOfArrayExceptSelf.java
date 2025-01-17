package Solutions;


//first approach:
/*
    public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] prefixProduct = new int[n];
    int[] suffixProduct = new int[n];
    
    int curr = 1;
    for (int i = 0; i < n; i++) {
        prefixProduct[i] = curr;
        curr *= nums[i];
    }
    
    curr = 1;
    for (int i = n - 1; i >= 0; i--) {
        suffixProduct[i] = curr;
        curr *= nums[i];
    }
    
    for (int i = 0; i < n; i++) {
        nums[i] = prefixProduct[i] * suffixProduct[i];
    }
    return nums;
}

 */

//more optimal approach:
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        
        //filling ans with prefix products:
        int curr=1;
        for(int i=0;i<n;i++)
        {
            ans[i]=curr;
            curr*=nums[i];//prefix product for next iteration
        }

        // finding suffix product and filling ans with ans*suffix product 
        curr=1;
        for(int i=n-1;i>=0;i--)
        {
            ans[i]*=curr;
            curr*=nums[i];//suffix product for next iteration
        }

        return ans;
    }
}
