package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.Main;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.SQLRequests;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.SQLRequests.*;

public class UserDaoJDBCImpl extends Util implements UserDao {

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(CREATE_TABLE);
            System.out.println("Table created");
        } catch (SQLException e) { //тут я хз можно через IF NOT EXISTS, но тогда пользователь не узнает,
            if (e.getMessage().equals("Table 'users' already exists")) { //что таблица существует, поэтому я пошёл этим путём
                System.out.println(e.getMessage());
            }
        }

    }

    public void dropUsersTable() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(DROP_TABLE);
            System.out.println("Table Dropped");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User added");
        } catch (SQLException e) {
            System.out.println("some error in save user");
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("User deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("some error in save user");
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Some problem with get all users");
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(CLEAN_TABLE);
            System.out.println("table cleaned");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Some error clean table");
        }
    }

//    public void removeUserById(long id) throws SQLException {
//        Connection connection = getConnection();
//        PreparedStatement preparedStatement;
//        String sqlRequestDeleteUser = "DELETE FROM users where id = ?";
//        preparedStatement = connection.prepareStatement(sqlRequestDeleteUser);
//        preparedStatement.setInt(1, (int) id);
//        int result = preparedStatement.executeUpdate();
//        connection.commit();
//    }
//
//    public List<User> getAllUsers() throws SQLException {
//        Connection connection = getConnection();
//        Statement statement = null;
//        ResultSet resultSet = null;
//        try {
//            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
//            connection.setAutoCommit(false);
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(SQLRequests.SELECT_ALL);
//            ArrayList<User> result = new ArrayList<>();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String lastName = resultSet.getString("lastName");
//                byte age = (byte) resultSet.getInt("age");
//                result.add(new User(id, name, lastName, age));
//            }
//            connection.commit();
//            return result;
//        } catch (SQLException e) {
//            Util.rollbackQuery(connection);
//            System.out.println(e.getMessage());
//            throw new SQLException(e);
//        } finally {
//            Util.closeQuietly(resultSet);
//            Util.closeQuietly(statement);
//            Util.closeQuietly(connection);
//        }
//    }


}
