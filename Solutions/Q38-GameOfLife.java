package Solutions;

class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                int liveNeighbours=countLiveNeighbours(board,row,col,m,n);
                if((liveNeighbours>3 || liveNeighbours<2) && board[row][col]==1){
                    board[row][col]=-1;
                }else if(liveNeighbours==3 && board[row][col]==0){

                    board[row][col]=2;
                }

            }
        }

        //modifying board:
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(board[i][j]==-1){
                board[i][j]=0;
               }else if( board[i][j]==2){
                board[i][j]=1;
               }
            }
        }
    }

    private int countLiveNeighbours(int [][]board,int row,int col,int m,int n)
    {
        int [][] directions={{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        int count=0;
        for(int[]dir:directions){
            int i=row+dir[0], j=col+dir[1];
            if(i>=0 && i<m && j>=0 && j<n && Math.abs(board[i][j])==1){
                count++;
            }
        }
        return count;
    } 
}