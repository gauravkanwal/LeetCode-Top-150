package Solutions;

class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int res=0;
        while(i<j)
        {
            //calculating water between i and j:
            int currWater=Math.min(height[i],height[j])*(j-i);

            res=Math.max(res,currWater);

            if(height[i]<=height[j]) i++;
            else j--;
        }
        return res;
    }
}