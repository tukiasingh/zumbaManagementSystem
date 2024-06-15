package org.example.db;
import org.example.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    User user = new User();
    DB db = DB.getDB();


    public int addUser(User user) {
        int result = 0;
        try {
            String sql = "insert into User values(null, ?,?)";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            result = db.executeUpdate(preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getPasswordForEmail(String email) {
        ResultSet resultSet = null;
        String password = null;
        try {
            String sql = "select password from User where email = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            resultSet = db.executeQuery(preparedStatement);
            if (resultSet.next()) {
                password = resultSet.getString("password");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return password;

    }



}
