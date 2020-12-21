package composite;

/**
 * @author Grey
 * @date 2020/4/14
 */
public class LeafNode extends Node {

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }
}
