class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int res=0;
        for (int i=31;i>=0;i--) {
            if((left&(1<<i)) == (right&(1<<i))){//prefix matching
                int t=(left&(1<<i)); 
                res|=t; //building res
            }
            else break;
        }
        return res;
    }
}

//Approach 2:
class Solution1 {
    public int rangeBitwiseAnd(int left, int right) {
        int i=0;
        while(left!=right){
            left>>=1;
            right>>=1;
            i++;
        }
        return left<<i;
    }
}