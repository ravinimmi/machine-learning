class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
        this.value = value;
    }

}

class BinaryTreeExample {
    public static void main(String[] s) {
        BinaryTree root = new BinaryTree(10);

        System.out.println("left: " + root.left);
        System.out.println("right: " + root.right);

        root.left = new BinaryTree(2);
        root.right = new BinaryTree(6);

        System.out.println("value: " + root.value);
        System.out.println("left: " + root.left.value);
        System.out.println("right: " + root.right.value);
    }
}