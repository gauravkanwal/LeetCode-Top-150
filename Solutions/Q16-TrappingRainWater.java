package Solutions;

//my solution:
class Solution {
    public int trap(int[] height) {
        int i=0,j=1,n=height.length;
        int count=0,res=0;
        while(j<n)
        {
            if(height[j]>=height[i]){
                res+=count;
                count=0;
                i=j;
            }

            else
            {
                count+=height[i]-height[j];
            }

            j++;
        }

        //checking from last:
        int k=i;//we have calulated res for index less than i so now we will calculate if we missed any thing after i by traversing array backwards.
        i=n-1;
        j=n-2;
        count=0;
        while(j>=k)
        {
            if(height[j]>=height[i]){
                res+=count;
                count=0;
                i=j;
            }

            else
            {
                count+=height[i]-height[j];
            }

            j--;   
        }
    return res;
    }
}
