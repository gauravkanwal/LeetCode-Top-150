package Solutions;

class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] buckets=new int[n+1];

        //filling the buckets array:
        for(int c:citations)
        {
            if (c>=n) buckets[n]++; //as maximum h index can not be grater than the number of papers i.e. size of array
            else buckets[c]++;
        }

        //finding the h-index:
        int count=0;
        for(int i=n;i>=0;i--)
        {
            count+=buckets[i];//papers containing k citations will always contain k-1 citation.
            if(count>=i) return i ; 
        }
        return 0;
    }
}