class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n>0) return recurse(x,n,1);
        return recurse(1/x,-(long)n,1);
    }

    private double recurse(double x, long n, double extra){
        if(n==1) return x*extra;
        if(n%2==0) return recurse(x*x, n/2 , extra);
        return recurse(x*x,n/2,extra*x);
    }
}
