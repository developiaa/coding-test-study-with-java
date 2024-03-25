package basic;

public class Node2 {
    private Node2 parent = null;

    public boolean isConnected(Node2 o) {
        return root() == o.root();
    }

    public void merge(Node2 o) {
        if (isConnected(o)) return;
        o.parent = this;
    }

    private Node2 root() {
        if (parent == null) return this;
        return parent = parent.root();
    }
}
