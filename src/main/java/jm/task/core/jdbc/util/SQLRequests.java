package jm.task.core.jdbc.util;

public class SQLRequests {

    public static final String URL = "jdbc:mysql://localhost:3306/mydb";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String DRIVER = "com.mysql.jdbc.Driver";

    public static final String CREATE_TABLE =
            "CREATE TABLE users (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `lastName` VARCHAR(45) NOT NULL,\n" +
                    "  `age` INT(3) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;";

    public static final String DELETE_USER = "DELETE FROM users where id = ?";

    public static final String SELECT_ALL = "SELECT * FROM users";

    public static final String INSERT_USER = "INSERT INTO users (name, lastName, age) values (?, ?, ?)";

    public static final String CLEAN_TABLE = "TRUNCATE users;";


    public static final String DROP_TABLE = "DROP TABLE users;";
}
