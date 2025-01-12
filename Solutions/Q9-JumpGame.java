package Solutions;


//my solution: time complexity =O(n)
// class Solution {
//     public boolean canJump(int[] nums) {
//         int i=nums.length-2;
//         while(i>=0)
//         {
//             if(nums[i]==0)
//             {
//                 boolean value=false;
//                 int j=i-1;
//                 while(j>=0 && value==false)
//                 {

//                     if(nums[j]>i-j) value=true;
//                     j--;
//                 }
//                 if (value==true)
//                 {
//                     i=j;
//                     continue;
//                 }
//                 else return false;
//             }
//             i--;
//         }
//         return true;
//     }
// }

 
//solution with more simpler code:
class Solution {
    public boolean canJump(int[] nums) {
        int i=nums.length-2;
        int goal=nums.length-1;
        while(i>=0)
        {
            if(i+nums[i]>=goal) goal=i;//if goal is reachable we move goal to left 
            i--;
        }
        return goal==0;
    }
} 