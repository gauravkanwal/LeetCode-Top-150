// Aproach 1: 
/* 
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length, n=nums2.length;
        int [] res=new int[m+n];
        int i=0,j=0,idx=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                res[idx]=nums1[i];
                i++;
            }else{
                res[idx]=nums2[j];
            j++;
        }
        idx++;
    }
    
    while(i<m) res[idx++]=nums1[i++];
    while(j<n) res[idx++]=nums2[j++];
    
    int total=m+n;
    if(total%2==0){
        double median=(res[total/2]+res[(total/2)-1])/2.0;
        return median;
    }
    return res[total/2];
}
}
*/

//Aproach 2:
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;

        if (m > n)
            return findMedianSortedArrays(nums2, nums1);

        int totalLeft = (m + n + 1) / 2;

        int l = 0, r = m;

        while (l <= r) {

            int partitionA = (l + r) / 2;
            int partitionB = totalLeft - partitionA;

            int aLeft  = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int aRight = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];

            int bLeft  = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int bRight = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            if (aLeft <= bRight && bLeft <= aRight) {

                if ((m + n) % 2 == 0) {
                    return (Math.max(aLeft, bLeft)
                          + Math.min(aRight, bRight)) / 2.0;
                } else {
                    return Math.max(aLeft, bLeft);
                }

            } else if (aLeft > bRight) {
                r = partitionA - 1;
            } else {
                l = partitionA + 1;
            }
        }

        return 0.0;
    }
}
