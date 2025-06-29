package org.example.utils;

import java.util.*;

public class GenerateID {
    private final Random rand;
    private final Set<Integer> used;
    private static final int MAX_SIZE = 100_000;

    public GenerateID() {
        this.rand = new Random();
        this.used = new LinkedHashSet<>();
    }

    public synchronized int getId() {
        int id;
        do {
            id = rand.nextInt();
        } while (!used.add(id));
        if (used.size() > MAX_SIZE) {
            Iterator<Integer> it = used.iterator();
            it.next();
            it.remove();
        }
        return id;
    }
}
