package Solutions;

//solution:
class Solution {

    //reverse function for an array in range:from start to end index:
    public void reverse(int[]nums,int start,int end)
    {
        while(start<end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        
        int n=nums.length;

        k=k%n;//minimizing the extra rotation

        //reversing the part1:
        reverse(nums,0,n-k-1);

        //reversing the part2:
        reverse(nums,n-k,n-1);

        //then reversing the whole array:
        reverse(nums,0,n-1);

    }
}