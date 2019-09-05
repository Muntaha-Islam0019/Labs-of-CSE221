package Tasks;

class DisjointSet {

    private Node[] nodes;

    DisjointSet(int nE){

        if (nE < 0)
            throw new IllegalArgumentException("Number of elements must be non-negative");
        nodes = new Node[nE];
        for (int i = 0; i < nE; i++) {
            Node node = new Node();
            node.parent = node;
            node.rank = 0;
            nodes[i] = node;
        }
    }

    private Node find(int elemIndex) {
        if (elemIndex < 0 || elemIndex >= nodes.length)
            throw new IndexOutOfBoundsException();
        return find(nodes[elemIndex]);
    }

    private static Node find(Node n) {
        if (n.parent != n)
            n.parent = find(n.parent);
        return n.parent;
    }

    boolean inSameSet(int eI0, int eI1) {
        return find(eI0) == find(eI1);
    }

    void union(int eI0, int eI1) {

        Node repr0 = find(eI0);
        Node repr1 = find(eI1);

        if (repr0 == repr1)
            return;

        if (repr0.rank > repr1.rank)
            repr1.parent = repr0;
        else if (repr1.rank > repr0.rank)
            repr0.parent = repr1;
        else {
            repr1.parent = repr0;
            repr0.rank++;
        }
    }


    private static final class Node {

        Node parent;
        int rank;

    }
}