class Solution {
    public Pair fun(Node root){
        if(root == null) return new Pair(-1, -1);
        Pair leftPair = fun(root.left);
        Pair rightPair = fun(root.right);
        return new Pair(Math.max(leftPair.left_width + 1, rightPair.left_width - 1), Math.max(rightPair.right_width + 1, leftPair.right_width - 1));
    }
    // Function to find the vertical width of a Binary Tree.
    public int verticalWidth(Node root) {
        // code here.
        if(root == null) return 0;
        Pair rootPair = fun(root);
        return rootPair.right_width + rootPair.left_width + 1;
    }
}
class Pair{
    int left_width;
    int right_width;
    Pair() {}
    Pair (int l, int r){
        this.left_width = l;
        this.right_width = r;
    }
}
