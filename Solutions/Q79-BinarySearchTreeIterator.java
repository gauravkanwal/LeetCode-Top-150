class BSTIterator {
    ArrayList<Integer> arr=new ArrayList<>();
    int i=-1;

    public BSTIterator(TreeNode root) {
        traverse(root);
    }

    private void traverse(TreeNode root){
        if(root==null) return;

        traverse(root.left);
        arr.add(root.val);
        traverse(root.right);
        return;
    }
    
    public int next() {
        i++;
        return arr.get(i);
    }
    
    public boolean hasNext() {
        return i+1<arr.size();
    }
}