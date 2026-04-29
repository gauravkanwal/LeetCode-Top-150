class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        boolean carry=false;
        int i=n-1;
        while(i>=0){
            if(digits[i]==9){
                digits[i]=0;
                carry=true;
            }
            else {
                digits[i]+=1;
                carry=false;
            }
            i--;

            if(!carry) return digits;
        }

        int[] res=new int[n+1];
        res[0]=1;
        int idx=1;
        for(int d:digits){
            res[idx++]=d;
        }

        return res;

    }
}