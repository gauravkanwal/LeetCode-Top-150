package Solutions;

//my approach:

// class Solution {
//     public int candy(int[] ratings) {
//         int n=ratings.length;
//         int[] candies=new int[n];
//         int totalCandies=0;
        
//         for(int i=0;i<n;i++)
//         {
//             if(i==0)
//             {
//                 candies[i]=1;
//                 totalCandies++;
//                 continue;
//             }
//             if(ratings[i]>ratings[i-1])
//             {
//                 candies[i]=candies[i-1]+1;
//                 totalCandies+=candies[i];
//             }
//             else
//             {
//                 candies[i]=1;
//                 totalCandies++;
//             }
//         }

//         for(int i=n-2;i>=0;i--)
//         {
//             if(ratings[i]>ratings[i+1])
//             {
//                 totalCandies-=candies[i];
//                 candies[i]=Math.max(candies[i],candies[i+1]+1);
//                 totalCandies+=candies[i];
//             }
//         }
//         return totalCandies;
//     }
// }


//optimal approach:
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int totalCandies=n;
        int i=1;
        while(i<n)
        {
            //for equal intervals:
            if(ratings[i]==ratings[i-1])
            {
                i++;
                continue;
            }

            //for increasing slope:
            int peak=0;
            while(i<n && ratings[i]>ratings[i-1])
            {
                peak++;
                totalCandies+=peak;
                i++;
            }

            //for decreasing slope:
            int valley=0;
            while(i<n && ratings[i]<ratings[i-1])
            {
                valley++;
                totalCandies+=valley;
                i++;
            }

            //if a dicreasing slopes strating point is same as the peak of an increasing slope we dont want to count that peak two times so:
            totalCandies-=Math.min(peak,valley);
        }
        return totalCandies;
    }
}