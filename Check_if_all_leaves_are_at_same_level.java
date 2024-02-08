class Solution{
  static boolean areLeavesAtTheSameLevel(Node root) {
        // Your code here
        Set<Integer> set = new HashSet<>();
        rootLevel(root.left, 1, set);
        rootLevel(root.right, 1, set);
        return set.size() <= 1;
    }

    static void rootLevel(Node root, int n, Set<Integer> set){
        if(root == null) return;
        if(root.left == null && root.right == null){
            set.add(n);
            return;
        }
        rootLevel(root.left, n+1, set);
        rootLevel(root.right, n+1,  set);
    }
}
