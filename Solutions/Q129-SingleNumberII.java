class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<32;i++){
            int sum=0;
            for(int num:nums){
                int bit=num>>i&1;
                sum+=bit;
            }
            if(sum%3!=0)res|=1<<i;
        }   
        return res;
    }
}