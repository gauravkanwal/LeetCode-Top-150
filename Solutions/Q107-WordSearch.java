class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length; 
        boolean [][] visited= new boolean[m][n];
        for(int i=0;i<m;i++){
            for( int j=0;j<n;j++){
                if(board[i][j]!=(word.charAt(0))) continue;
                if(backtrack(board,word,visited,0,i,j)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, boolean[][] visited, int idx, int i, int j)
    {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return false;
        if(visited[i][j]) return false;
        if(board[i][j]!=word.charAt(idx)) return false;
        if(idx==word.length()-1) return true;

        if(!visited[i][j]){
            visited[i][j]=true;
            if(backtrack(board,word,visited,idx+1,i-1,j)) return true;
            if(backtrack(board,word,visited,idx+1,i+1,j)) return true;
            if(backtrack(board,word,visited,idx+1,i,j+1)) return true;
            if(backtrack(board,word,visited,idx+1,i,j-1)) return true;
            visited[i][j]=false;
        }
        return false;
    }
}