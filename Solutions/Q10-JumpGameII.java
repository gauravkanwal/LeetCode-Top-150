package Solutions;

//My solution with O(n^2):
// class Solution {
//     public int jump(int[] nums) {
//         int n=nums.length;
//         int i=n-1;
//         int count=0;
//         while(i>0)
//         {
//             int j=i-1,temp=i;
//             while(j>=0)
//             {
//                 if(j+nums[j]>=i)
//                 {
//                     temp=j;
//                 }
//                 j--;
//             }
//             i=temp;
//             count++;
//         }
//         return count;
//     }
// }

//optimal solution:
class Solution {
    public int jump(int[] nums) {
         int currEnd=0,farthest=0,jumps=0;
         int n=nums.length;
         if(n==1)return 0;
         for(int i=0;i<n;i++)
         {
            farthest=Math.max(farthest,i+nums[i]);
            if(i==currEnd)
            {
                jumps++;
                currEnd=farthest;
            }
            if(currEnd>=n-1) break;
         }
         return jumps;
    }
}