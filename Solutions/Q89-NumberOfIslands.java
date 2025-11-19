class Solution {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    turn1to0(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    void turn1to0(char[][]grid,int row,int col){

        if(row<0 || row>=m || col<0 || col>=n) return;
        if(grid[row][col]=='0') return;
        
        //turn to 0
        grid[row][col]='0';

        //look left:
        turn1to0(grid,row,col-1);
        
        //look right:
        turn1to0(grid,row,col+1);

        //look top:
        turn1to0(grid,row-1,col); 

        //look down:
        turn1to0(grid,row+1,col);

    }
}