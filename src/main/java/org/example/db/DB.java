package org.example.db;



import java.sql.*;

public class DB {
    public Connection connection;

    public static DB db = new DB();

    private DB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("[DB]: JDBC driver loaded successfully!");
            String url = "jdbc:mysql://localhost:/zms";
            String username = "vijay";
            String password = "Vijay@isha1157";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("[DB]: Connection Created to the Database!");
        }catch(Exception e){
            e.printStackTrace();

        }
    }

    public static DB getDB(){
        return db;
    }

    public void closeConnection () {
        try{
            connection.close();
            System.out.println("[DB]: Connection to Database Closed!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public int executeUpdate(PreparedStatement statement){
        int result = 0;
        try {
            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public ResultSet executeQuery(PreparedStatement statement){
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;

    }
}

