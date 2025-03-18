package Solutions;
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int i=0,j=-1;
        int rows=matrix.length;
        int cols=matrix[0].length;
        boolean [][] visited=new boolean[rows][cols];
        while(list.size()<rows*cols)
        {
            //to right:
            while( j+1<cols && !visited[i][j+1] )
            {
                j++;
                visited[i][j]=true;
                list.add(matrix[i][j]);
            }

            //to down:
            while( i+1<rows && !visited[i+1][j])
            {
                i++;
                visited[i][j]=true;
                list.add(matrix[i][j]);
            }

            //to left:
            while( j-1>=0 && !visited[i][j-1])
            {
                j--;
                visited[i][j]=true;
                list.add(matrix[i][j]);
            }

            //to up:
            while( i-1>=0 && !visited[i-1][j])
            {
                i--;
                visited[i][j]=true;
                list.add(matrix[i][j]);
            }
        }
        return list;
    }
}