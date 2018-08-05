import sun.misc.Queue;

import java.util.ArrayList;
import java.util.Objects;

class Node {
    int value;
    int depth;
    ArrayList<Node> children;

    Node(int value) {
        this.value = value;
        this.depth = -1;
        this.children = new ArrayList<>();
    }

}

class Tree {
    Node root;

    Tree(Node node) {
        this.root = node;
        this.root.depth = 0;
    }

    void addChild(Node node, Node child) {
        child.depth = node.depth + 1;
        node.children.add(child);
    }

    int getSize() {
        return this.getSize(this.root);
    }

    void printLevelOrder() {
        Queue<Node> nodes = new Queue<>();
        nodes.enqueue(this.root);

        Node prevNode = null;
        while(!nodes.isEmpty()) {
            try {
                Node node = nodes.dequeue();

                if(!Objects.isNull(prevNode) && (prevNode.depth != node.depth)) {
                    System.out.println();
                }

                System.out.print(node.value + " ");
                for(Node n: node.children) {
                    nodes.enqueue(n);
                }
                prevNode = node;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int getSize(Node node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        else {
            int size = 1;
            for(Node n: node.children) {
                size += getSize(n);
            }
            return size;
        }
    }

}

class TreeExample {
    public static void main(String[] s) {
        Tree t = new Tree(new Node(10));

        System.out.println("children: " + t.root.children);
        System.out.println("value: " + t.root.value);

        t.addChild(t.root, new Node(20));
        t.addChild(t.root, new Node(30));
        t.addChild(t.root.children.get(1), new Node(40));
        t.addChild(t.root.children.get(1).children.get(0), new Node(50));
        System.out.println("value: " + t.root.children.get(0).value);

        System.out.println("size: " + t.getSize());

        t.printLevelOrder();
        /*
                   10
                  20 30
                       40
                         50
         */
    }
}

