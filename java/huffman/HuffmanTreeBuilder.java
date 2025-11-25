package huffman;

import java.util.PriorityQueue;

public final class HuffmanTreeBuilder {

    private static final int ALPHABET = 256;

    public static HuffmanNode build(int[] freq) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();

        for (int i = 0; i < ALPHABET; i++) {
            if (freq[i] > 0) {
                pq.add(new HuffmanNode(freq[i], i, null, null));
            }
        }

        if (pq.isEmpty()) {
            return new HuffmanNode(0, -1, null, null);
        }

        if (pq.size() == 1) {
            HuffmanNode leaf = pq.poll();
            return new HuffmanNode(leaf.frequency, -1, leaf, null);
        }

        while (pq.size() > 1) {
            HuffmanNode a = pq.poll();
            HuffmanNode b = pq.poll();
            pq.add(new HuffmanNode(a.frequency + b.frequency, -1, a, b));
        }

        return pq.poll();
    }
}
