package huffman;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public final class BitInputStream implements Closeable {

    private final InputStream in;
    private int currentByte;
    private int bitsLeft;

    public BitInputStream(InputStream in) {
        this.in = in;
        this.currentByte = 0;
        this.bitsLeft = 0;
    }

    public int readBit() throws IOException {
        if (bitsLeft == 0) {
            currentByte = in.read();
            if (currentByte == -1) {
                return -1;
            }
               bitsLeft = 8;
        }
        int bit = (currentByte >>> 7) & 1;
        currentByte <<= 1;
        bitsLeft--;
        return bit;
    }

    @Override
    public void close() throws IOException {
        in.close();
    }
}
