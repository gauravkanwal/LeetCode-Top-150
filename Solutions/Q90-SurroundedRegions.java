class Solution {
    int m;
    int n;
    public void solve(char[][] board) {
        m=board.length;
        n=board[0].length;

        //for first and last row:
        for(int i=0;i<n;i++){
            if(board[0][i]=='O') turnOtoY(board,0,i);
            if(board[m-1][i]=='O') turnOtoY(board,m-1,i);
        }

        //for first and last column:
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') turnOtoY(board,i,0);
            if(board[i][n-1]=='O') turnOtoY(board,i,n-1);
        }


        //turning O to X & Y to O again
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='Y') board[i][j]='O';
            }
        }

    }

    public void turnOtoY(char[][] board,int i,int j){
        if(i<0 || i>=m || j<0 || j>=n) return;
        if(board[i][j]=='X' || board[i][j]=='Y') return;
        board[i][j]='Y';
        turnOtoY(board,i,j-1);
        turnOtoY(board,i,j+1);
        turnOtoY(board,i-1,j);
        turnOtoY(board,i+1,j);

    }
}