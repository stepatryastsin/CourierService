package org.example.Может_не_пригодиться.ID;

import java.util.Objects;
import java.util.Random;

public class OrderId implements ID {
    private Random random;
    String ID_TYPE = "1234";
    int length = 4;
    private char[] symbols;
    private char[] buf;

    public OrderId() {
        random = new Random();
        if (length < 1) throw new IllegalArgumentException();
        if (ID_TYPE.length() < 2) throw new IllegalArgumentException();
        random = Objects.requireNonNull(random);
        this.symbols = ID_TYPE.toCharArray();
        this.buf = new char[length];
    }

    @Override
    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    @Override
    public String toString() {
        return "OrderId{" +
                "buf=" + buf +
                '}';
    }
}
