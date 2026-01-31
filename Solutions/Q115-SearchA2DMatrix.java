class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length, c=matrix[0].length;
        int top=0,bottom=r-1;
        while(top<=bottom){
            int mid=(top+bottom)/2;
            if(matrix[mid][0]==target || matrix[mid][c-1]==target) return true;
            else if(matrix[mid][0]<target && matrix[mid][c-1]>target)break;
            else if(matrix[mid][0]>target) bottom=mid-1;
            else top=mid+1;
        }

        int left=0,right=c-1;
        int row=(top+bottom)/2;

        while(left<=right){
            int mid=(left+right)/2;
            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid]>target) right=mid-1;
            else left=mid+1;
        }


        return false;
    }
}


