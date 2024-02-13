class Solution{
    Node cloneGraph(Node node){
        Node cur = new Node(node.val);
        Map<Node, Node> map = new HashMap<>();
        map.put(node, cur);
        cloneGraph(node, map, cur);
        return cur;
    }
    
    static void cloneGraph(Node node, Map<Node, Node> map, Node cur){
        for(var nei : node.neighbors){
            if(map.get(nei) != null) cur.neighbors.add(map.get(nei));
            else{
                Node next = new Node(nei.val);
                cur.neighbors.add(next);
                map.put(nei, next);
                cloneGraph(nei, map, next);
            }
        }
    }
}
