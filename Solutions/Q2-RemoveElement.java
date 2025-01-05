package Solutions;


class Solution {
    public int removeElement(int[] nums, int val) {
        int writeIndex=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=val)
            {
                nums[writeIndex]=nums[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }
}