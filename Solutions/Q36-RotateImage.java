package Solutions;
class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //first transpose the matrix i.e. swap matrix[i][j] with matrix[j][i]
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        //then flip the matrix hoeizontally i.e. swap matrix[i][j] with matrix[i][n-1-j]
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n/2;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
    }
}