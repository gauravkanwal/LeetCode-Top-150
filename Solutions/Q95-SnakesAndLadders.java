public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        Queue<Integer> q= new LinkedList<>();
        boolean[][] visited=new boolean[n][n];
        
        q.offer(1);
        visited[n-1][0]=true;

        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int x=q.poll();
                if(x==n*n) return steps;

                for(int j=x+1;j<=x+6;j++){
                    if(j>n*n) break;
                    int[] cordinates=getCordinates(n,j);

                    if(visited [cordinates[0]] [cordinates[1]] ){
                        continue;
                    }
                    visited[cordinates[0]][cordinates[1]]=true;

                    if(board[cordinates[0]] [cordinates[1]] > 0 ){
                        q.offer(board[cordinates[0]][cordinates[1]]);
                        continue;
                    } 

                    q.offer(j);

                }
            }
            steps++;
        }

        return -1;
    }

    private int[] getCordinates(int n, int num){
        //here 1 number is not in 0,0 its in [n-1][0]
        //for example for number 1 and n=6 the normal index would be 0,0
        //but here it's (5,0)
        //so we can say 
        // rowFromBottomToTop(x) = (n-1) -  rowFromTopToBottom(n)
        int[] cordinates=new int[2];
        // normally we can get row by num-1 / n
        //so here we can get row by:
        int row = (n-1)-((num-1)/n);
        cordinates[0]=row;

        //normally we can get column by num-1 % n
        //here it applies when the counting is from left to right
        //but for right to left ot reverses it becomes (n-1) - row from left to right
        // now the task is to know when the numbering is from left to right and when the numbering is from right to left
        //for this if (n is even && row is even) || (n is odd && row is odd) it means that time the numbering is from right to left else its left to right

        boolean rightToLeft=((n%2==0) == (row%2==0));  

        if(!rightToLeft){
            cordinates[1]=(num-1) % n;
        }else{
            cordinates[1]=( (n-1)-((num-1)%n) );
        }

        return cordinates;
    }
} {
    
}
