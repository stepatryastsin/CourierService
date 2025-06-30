package org.example.entity.validate;

public interface Constraint<T> {
    void check(T data);
}
