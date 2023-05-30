package org.example.workwithdata;

import java.util.List;

public interface SaveData {
    void save(String path, List<Object> data) throws ClassNotFoundException;
}
