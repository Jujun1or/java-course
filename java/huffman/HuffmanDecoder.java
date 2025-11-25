package huffman;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class HuffmanDecoder {

    private static final int MAGIC = 0x48554646;
    private static final int ALPHABET = 256;

    public static void decode(Path input, Path output) throws Exception {
        try (InputStream is = Files.newInputStream(input);
             DataInputStream in = new DataInputStream(is)) {

            int magic = in.readInt();
            if (magic != MAGIC) {
                throw new IllegalStateException("Invalid format");
            }

            int[] freq = new int[ALPHABET];
            for (int i = 0; i < ALPHABET; i++) {
                freq[i] = in.readInt();
            }

            long originalLength = in.readLong();

            HuffmanNode root = HuffmanTreeBuilder.build(freq);

            try (BitInputStream bitIn = new BitInputStream(in);
                 OutputStream out = Files.newOutputStream(output)) {

                if (originalLength == 0) {
                    return;
                }

                if (root.isLeaf()) {
                    byte val = (byte) root.symbol;
                    for (long i = 0; i < originalLength; i++) {
                        out.write(val);
                    }
                    return;
                }

                HuffmanNode current = root;
                long written = 0;

                while (written < originalLength) {
                    int bit = bitIn.readBit();
                    if (bit == -1) {
                        throw new IllegalStateException("Unexpected end of data");
                    }

                    current = (bit == 0) ? current.left : current.right;

                    if (current.isLeaf()) {
                        out.write(current.symbol);
                        written++;
                        current = root;
                    }
                }
            }
        }
    }
}
