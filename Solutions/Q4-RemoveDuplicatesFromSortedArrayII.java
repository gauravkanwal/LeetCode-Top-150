package Solutions;

class Solution {
    public int removeDuplicates(int[] nums) {
        int writeIndex=0,n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(writeIndex<2 || nums[writeIndex-2]<nums[i])
            {
                nums[writeIndex]=nums[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }
}
