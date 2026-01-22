class Solution {
    HashSet<Integer> markedCols=new HashSet<>();
    HashSet<Integer> markedDignl1=new HashSet<>();
    HashSet<Integer> markedDignl2=new HashSet<>();
    int res;
    public int totalNQueens(int n) {
        res=0;
        totalQueensHelper(n,0);
        return res;
    }

    private void totalQueensHelper(int n,int row){
        if(row==n){
            res++;
            return;
        }

        for(int col=0;col<n;col++){
            if(markedCols.contains(col)
                        ||
               markedDignl1.contains(row+col)
                        ||
               markedDignl2.contains(row-col)
            )continue;

            markedCols.add(col);
            markedDignl1.add(row+col);
            markedDignl2.add(row-col);
            
            totalQueensHelper(n,row+1);

            markedCols.remove(col);
            markedDignl1.remove(row+col);
            markedDignl2.remove(row-col);
        }
    }

}