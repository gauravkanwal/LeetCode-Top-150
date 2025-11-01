//Approach 1: BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
                if (i == size - 1)
                    ans.add(node.val);
            }
        }
        return list;
    }
}

//Approach 2: DFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode root, List<Integer> result, int level) {
        if (root == null)
            return;
        if (result.size() == level) {
            result.add(root.val);
        }

        rightView(root.right, result, level + 1);
        rightView(root.left, result, level + 1);
    }
}