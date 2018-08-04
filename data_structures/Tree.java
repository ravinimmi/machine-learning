import java.util.ArrayList;

class Tree {
    int value;
    ArrayList<Tree> children;

    Tree(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    void addChild(Tree child) {
        this.children.add(child);
    }
}

class TreeExample {
    public static void main(String[] s) {
        Tree root = new Tree(10);

        System.out.println("left: " + root.children);
        System.out.println("value: " + root.value);

        root.addChild(new Tree(20));
        System.out.println("value: " + root.children.get(0).value);

    }
}
