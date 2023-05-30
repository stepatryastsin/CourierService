package org.example.workwithdata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class SaveDataToBD implements SaveData{
    @Override
    public void save(String path, List<Object> data) throws ClassNotFoundException {
        String username = "root";
        String password = "Stepan11022004";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(path,username,password)){
            System.out.println("Connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
