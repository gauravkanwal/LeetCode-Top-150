
// Solution1:
class Solution {
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            int lastBit=n&1;
            if(lastBit==1){
                res|=(1<<31-i);
            }
            n>>=1;
        }
        return res;

    }


}

// Solution2:
public int reverseBits(int n) {
    if (n == 0) return 0;
    
    int result = 0;
    for (int i = 0; i < 32; i++) {
        result <<= 1;
        if ((n & 1) == 1) result++;
        n >>= 1;
    }
    return result;
}
