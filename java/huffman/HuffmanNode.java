package huffman;

public final class HuffmanNode implements Comparable<HuffmanNode> {
    public final int frequency;
    public final int symbol;
    public final HuffmanNode left;
    public final HuffmanNode right;

    public HuffmanNode(int frequency, int symbol, HuffmanNode left, HuffmanNode right) {
        this.frequency = frequency;
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return Integer.compare(this.frequency, o.frequency);
    }
}
