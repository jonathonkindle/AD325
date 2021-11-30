class Solution {
    Map<Node, Node> map = new HashMap();

    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        map.put(node, new Node(node.val, new ArrayList<>()));//
        for (Node n : node.neighbors) {
            if (map.containsKey(n))
                map.get(node).neighbors.add(map.get(n));
            else
                map.get(node).neighbors.add(cloneGraph(n));
        }
        return map.get(node);
    }
}