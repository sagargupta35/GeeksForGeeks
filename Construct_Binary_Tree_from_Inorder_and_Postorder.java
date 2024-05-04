class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        return buildTree(in, post, n, 0, n-1, 0, n-1);
    }
    
    Node buildTree(int in[], int post[], int n, int st1, int end1, int st2, int end2) {
         // Your code here
        int rootData = post[end2];
        int idx = -1;
        for(int i = st1; i<=end1; i++){
            if(in[i] == rootData){
                idx = i;
                break;
            }
        }
        Node root = new Node(rootData);
        if(idx == st1){
            root.left = null;
        } else{
            root.left = buildTree(in, post, n, st1, idx-1, st2, st2+idx-st1-1);
        }
        if(idx == end1){
            root.right = null;
        } else{
            root.right = buildTree(in, post, n, idx+1, end1, st2+idx-st1, end2-1);
        }
        return root;
     }
}
