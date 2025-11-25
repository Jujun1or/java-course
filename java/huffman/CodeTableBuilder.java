package huffman;

public final class CodeTableBuilder {

    public static void buildCodes(HuffmanNode node, String prefix, String[] table) {
        if (node.isLeaf()) {
            table[node.symbol] = prefix.isEmpty() ? "0" : prefix;
            return;
        }

        buildCodes(node.left, prefix + "0", table);

        if (node.right != null) {
            buildCodes(node.right, prefix + "1", table);
        }
    }
}
