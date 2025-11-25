package huffman;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class HuffmanEncoder {

    private static final int MAGIC = 0x48554646;
    private static final int ALPHABET = 256;

    public static void encode(Path input, Path output) throws Exception {
        byte[] data = Files.readAllBytes(input);
        int[] freq = new int[ALPHABET];

        for (byte b : data) {
            freq[b & 0xFF]++;
        }

        HuffmanNode root = HuffmanTreeBuilder.build(freq);

        String[] codes = new String[ALPHABET];
        CodeTableBuilder.buildCodes(root, "", codes);

        try (OutputStream os = Files.newOutputStream(output);
             DataOutputStream out = new DataOutputStream(os);
             BitOutputStream bitOut = new BitOutputStream(out)) {

            out.writeInt(MAGIC);

            for (int f : freq) {
                out.writeInt(f);
            }

            out.writeLong(data.length);

            if (data.length == 0) {
                return;
            }

            if (root.isLeaf()) {
                for (int i = 0; i < data.length; i++) {
                    bitOut.writeBit(0);
                }
                bitOut.flush();
                return;
            }

            for (byte b : data) {
                String code = codes[b & 0xFF];
                for (int i = 0; i < code.length(); i++) {
                    bitOut.writeBit(code.charAt(i) == '1' ? 1 : 0);
                }
            }

            bitOut.flush();
        }
    }
}
