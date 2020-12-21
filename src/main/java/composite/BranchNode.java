package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grey
 * @date 2020/4/14
 */
public class BranchNode extends Node {
    private List<Node> nodes = new ArrayList<>();

    public List<Node> getNodes() {
        return nodes;
    }

    public BranchNode(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }

    public void addNode(Node node) {
        nodes.add(node);
    }
}
