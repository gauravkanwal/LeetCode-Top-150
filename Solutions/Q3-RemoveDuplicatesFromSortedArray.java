package Solutions;

class Solution {
    public int removeDuplicates(int[] nums) {
        int writeIndex=0;
        for(int num:nums)
        {
            if(writeIndex<1 || num>nums[writeIndex-1])
            {
                nums[writeIndex]=num;
                writeIndex++;
            }
        }
        return writeIndex;
    }
}