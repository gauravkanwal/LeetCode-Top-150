package Solutions;

class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] candies=new int[n];
        int totalCandies=0;
        
        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                candies[i]=1;
                totalCandies++;
                continue;
            }
            if(ratings[i]>ratings[i-1])
            {
                candies[i]=candies[i-1]+1;
                totalCandies+=candies[i];
            }
            else
            {
                candies[i]=1;
                totalCandies++;
            }
        }

        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                totalCandies-=candies[i];
                candies[i]=Math.max(candies[i],candies[i+1]+1);
                totalCandies+=candies[i];
            }
        }
        return totalCandies;
    }
}
