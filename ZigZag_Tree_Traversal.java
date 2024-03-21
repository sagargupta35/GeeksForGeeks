class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    boolean flag = true;
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node cur = q.poll();
            if(cur == null){
                flag = !flag;
                if(!q.isEmpty()) q.add(null);
                if(!list.isEmpty()){
                    res.addAll(list);
                    list.clear();
                }
            } else{
                if(flag) res.add(cur.data);
                else list.addFirst(cur.data);
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
        }
        if(!list.isEmpty()) res.addAll(list);
        return res;
	}
}
