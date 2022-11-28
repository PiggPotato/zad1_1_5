package jm.task.core.jdbc.util;

import java.sql.*;

import static jm.task.core.jdbc.util.SQLRequests.*;

public class Util {

//    public static Connection connection;
//    public static Statement statement;
//
//    static {
//        try {
//            connection = DriverManager.getConnection(URL,USER,PASSWORD);
//            System.out.println("Connect");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//    }
//    static {
//        try {
//            statement = connection.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }

    public Util(){
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }



//    public static void closeQuietly(ResultSet resultSet) {
//        if (resultSet != null){
//            try {
//                resultSet.close();
//            } catch (SQLException e) {
//                System.err.println(e.getMessage());
//            }
//        }
//    }
//
//    public static void closeQuietly(Statement statement) {
//        if (statement != null){
//            try {
//                statement.close();
//            } catch (SQLException e) {
//                System.err.println(e.getMessage());
//            }
//        }
//    }
//
//    public static void closeQuietly(Connection connection) {
//        if (connection != null){
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                System.err.println(e.getMessage());
//            }
//        }
//    }
//
//    public Connection getConnection() throws SQLException, ClassNotFoundException {
//        try (Connection connection = DriverManager.getConnection(url, user, password)) {
//            Class.forName(driver);
//            System.out.println("Connect");
//            return connection;
//        } catch (SQLException | ClassNotFoundException e) {
//            System.err.println(e.getMessage());
//            throw e;
//        }
//    }
//
//    public static void initDriver(String driver){
//        try {
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static void rollbackQuery(Connection connection){
//        if (connection != null){
//            try{
//                connection.rollback();
//            } catch (SQLException e) {
//                System.err.println(e.getMessage());
//            }
//        }
//    }
}
