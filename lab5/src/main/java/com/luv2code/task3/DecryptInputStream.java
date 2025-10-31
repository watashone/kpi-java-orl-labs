package com.luv2code.task3;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream {
    private final int key;

    public DecryptInputStream(InputStream in, int key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read() throws IOException {
        int b = super.read();
        return (b == -1) ? b : b - key;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int count = super.read(b, off, len);
        if (count == -1) return count;
        for (int i = off; i < off + count; i++) {
            b[i] = (byte)(b[i] - key);
        }
        return count;
    }
}

