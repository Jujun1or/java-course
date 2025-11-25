package huffman;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

public final class BitOutputStream implements Closeable {

    private final OutputStream out;
    private int currentByte;
    private int bits;

    public BitOutputStream(OutputStream out) {
        this.out = out;
        this.currentByte = 0;
        this.bits = 0;
    }

    public void writeBit(int bit) throws IOException {
        currentByte = (currentByte << 1) | bit;
        bits++;
        if (bits == 8) {
            out.write(currentByte);
            bits = 0;
            currentByte = 0;
        }
    }

    public void flush() throws IOException {
        if (bits > 0) {
            currentByte <<= (8 - bits);
            out.write(currentByte);
            bits = 0;
            currentByte = 0;
        }
        out.flush();
    }

    @Override
    public void close() throws IOException {
        flush();
        out.close();
    }
}
