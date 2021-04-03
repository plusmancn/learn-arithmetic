package cn.plusman.mybatis;

import java.sql.*;

/**
 * JDBC 连接示例
 * 概念示例：https://www.baeldung.com/java-jdbc
 * @author plusman
 * @since 2021/3/25 10:05 AM
 */
public class ApplicationJDBC {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://macair.plusman.cn:13306/learn-java?useSSL=false&amp;allowPublicKeyRetrieval=true&user=root&password=pL5K6yT$#0yEkkH5TrRE4Q");
        ) {
            statementCase(conn);
            // preparedStatementCase(conn);
            // callableStatementCase(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    /**
     *
     */
    
    /**
     * 存储过程需要预先创建
     * <pre>
     * delimiter //
     * CREATE PROCEDURE insertBlog (
     * 	OUT id INT,
     * 	IN article VARCHAR ( 49 )
     * ) BEGIN
     * 	INSERT INTO blog ( content, json_field )
     * 	VALUES
     * 		( article, '[]' );
     * 	SET id = LAST_INSERT_ID();
     * END //
     * delimiter;
     * </pre>
     *
     * 触发存储进程，直接返回结果
     * @param conn
     */
    public static void callableStatementCase(Connection conn) {
        String preparedSql = "{call insertBlog(?, ?)}";
        try (CallableStatement callableStatement = conn.prepareCall(preparedSql)) {
            callableStatement.setString(2, "Created from callableStatement");
            callableStatement.execute();
            int newId = callableStatement.getInt(1);
            System.out.println("New Record id is: " + newId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    /**
     * 使用预编译语句，直接返回结果
     * 在 mysql 预编译语句，可节约多少时间
     * @param conn
     */
    public static void preparedStatementCase(Connection conn) {
        String querySql = "SELECT * FROM blog WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(querySql)) {
            preparedStatement.setInt(1, 2);
            ResultSet resultSet = preparedStatement.executeQuery();
            printResult(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    
    /**
     * Statement：直接执行 SQL，直接返回结果
     * @param conn
     */
    public static void statementCase(Connection conn) {
        try (
            Statement statement = conn.createStatement();
        ) {
            try (ResultSet resultSet = statement.executeQuery("select * from blog")) {
                printResult(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
 
    public static void printResult(ResultSet rs) throws SQLException {
        while(rs.next()){
            //Retrieve by column name
            Integer id = rs.getInt("id");
            String content = rs.getString("content");
        
            //Display values
            System.out.print("ID: " + id);
            System.out.println(" | Content: " + content);
        }
    }
}
