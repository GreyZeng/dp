package composite;

/**
 * @author Grey
 * @date 2020/4/14
 */
public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode branch1 = new BranchNode("branch1");
        BranchNode branch2 = new BranchNode("branch2");
        branch1.addNode(new LeafNode("leaf1"));
        root.addNode(branch1);
        root.addNode(branch2);
        tree(root, 0);
    }

    static void tree(Node node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        node.print();

        if (node instanceof BranchNode) {
            for (Node n : ((BranchNode) node).getNodes()) {
                tree(n, depth + 1);
            }
        }
    }
}
