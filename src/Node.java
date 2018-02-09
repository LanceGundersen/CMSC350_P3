class Node<T extends Comparable<T>> {

    private T value;
    private Node<T> left;
    private Node<T> right;

    Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getA() {
        return left;
    }

    public void setA(Node<T> left) {
        this.left = left;
    }

    public Node<T> getB() {
        return right;
    }

    public void setB(Node<T> right) {
        this.right = right;
    }
}