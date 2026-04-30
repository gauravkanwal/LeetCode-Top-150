class Solution {
    public int mySqrt(int x) {
        int i=0,j=x;
        int res=0;
        while(i<=j){
            int mid=(i+((j-i)/2));
            if((long)mid*mid<=x){
                res=mid;
                i=mid+1;
            }else j=mid-1;
        }
        return res;
    }
}