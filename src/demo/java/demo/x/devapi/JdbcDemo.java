
package demo.x.devapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dev_gqsh_third_order", "root", "123456");

        PreparedStatement preparedStatement = connection.prepareStatement("select 1");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("1"));
        }

    }

}
