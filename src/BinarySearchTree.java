
/*+----------------------------------------------------------------------
 ||
 ||  Class BinarySearchTree
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Orders and compares the search nodes.
 ||
 ++-----------------------------------------------------------------------*/

class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    private String text;

    BinarySearchTree(T value) {
        this.root = new Node<>(value);
        this.text = "";
    }

    public void insert(T value) {
        insert(root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node != null) {
            if (value.compareTo(node.getValue()) < 0) {
                node.setA(insert(node.getA(), value));
            } else {
                node.setB(insert(node.getB(), value));
            }
            return node;
        } else {
            return new Node<>(value);
        }
    }

    public String ascendingOrder(Node<T> node) {
        if (node != null) {
            ascendingOrder(node.getA());
            text += node.getValue().toString() + " ";
            ascendingOrder(node.getB());
        }
        return text;
    }

    public String descendingOrder(Node<T> node) {
        if (node != null) {
            descendingOrder(node.getB());
            text += node.getValue().toString() + " ";
            descendingOrder(node.getA());
        }
        return text;
    }

    public Node<T> getRoot() {
        return root;
    }
}