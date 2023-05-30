package org.example.Может_не_пригодиться.ID;

import java.util.Objects;
import java.util.Random;

public class PersonID implements ID{
     private  Random random;

     String print;
     String ID_TYPE = "AABCDE12345";
    int length = 10;
     private char[] symbols;
     private char[] buf;

    public PersonID() {
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
        return "PersonID{"  +  buf + '}';
    }
}
