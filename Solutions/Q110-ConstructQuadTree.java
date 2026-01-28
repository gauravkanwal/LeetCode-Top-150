/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return constructHelper(grid,0,0,grid.length);
    }

    private Node constructHelper(int[][] grid,int i,int j,int n){
        if(n==1) return new Node(grid[i][j]==1,true);
        Node topLeft=constructHelper(grid,i,j,n/2);
        Node topRight=constructHelper(grid,i,j+(n/2),n/2);
        Node bottomLeft=constructHelper(grid,i+(n/2),j,n/2);
        Node bottomRight=constructHelper(grid,i+(n/2),j+(n/2),n/2);

        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            if(topLeft.val==topRight.val && topLeft.val==bottomLeft.val &&topLeft.val==bottomRight.val){
                return new Node(topLeft.val,true);
            }
        }

        return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);

    }
}