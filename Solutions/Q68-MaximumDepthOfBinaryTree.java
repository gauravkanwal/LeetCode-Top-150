
//Recursive Solution (DFS)
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}

//Iterative Solution (BFS)
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int count = 0;

        while (!q.isEmpty()) {
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            count++;
        }
        return count;
    }
}