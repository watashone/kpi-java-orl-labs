package com.luv2code.task3;

import java.io.FilterOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

public class EncryptOutputStream extends FilterOutputStream {
    private final int key;

    public EncryptOutputStream(OutputStream out, int key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(int b) throws IOException {
        super.write(b + key);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            b[i] = (byte)(b[i] + key);
        }
        super.write(b, off, len);
    }
}