import java.util.*;
public class BinaryTree1 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) return;
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelorder(Node root) {
            if (root == null) return;

            Queue<Node> q = new java.util.LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.poll();
                if (currNode == null) {
                    System.out.println();
                    if (!q.isEmpty()) {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) q.add(currNode.left);
                    if (currNode.right != null) q.add(currNode.right);
                }
            }
        }
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }
    public static int countofNodes(Node root){
        if(root == null){
            return 0;
        }
        int lcount = countofNodes(root.left);
        int rcount = countofNodes(root.right);
        return lcount + rcount + 1;
    }
    public static int sumofNodes(Node root){
        if(root == null){
            return 0;
        }
        int lsum = sumofNodes(root.left);
        int rsum = sumofNodes(root.right);
        return lsum + rsum + root.data;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildTree(nodes);

        System.out.println("Root Node: " + root.data);

        System.out.print("Preorder: ");
        BinaryTree.preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        BinaryTree.inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        BinaryTree.postorder(root);
        System.out.println();

        System.out.println("Level Order:");
        BinaryTree.levelorder(root);

        System.out.println("Height of Tree: " + height(root));
        System.out.println("No of Nodes: " + countofNodes(root));
        System.out.println("Sum of Nodes: " + sumofNodes(root));
    }
}
