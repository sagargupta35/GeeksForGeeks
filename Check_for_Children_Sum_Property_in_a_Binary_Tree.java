class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        if(root == null) return -1;
        int left = isSumProperty(root.left);
        int right = isSumProperty(root.right);
        if(left == -1 && right == -1) return 1;
        if(left == 0 || right == 0) return 0;
        if(root.left == null){
            return root.data == root.right.data ? 1 : 0;
        } else if(root.right == null) return root.data == root.left.data ? 1 : 0;
        if(root.left.data + root.right.data == root.data) return 1;
        return 0;
    }
}
