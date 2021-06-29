
package demo.x.devapi;

import java.sql.*;

public class JdbcDemo {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123456");

        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("select * from t_user where id =  " + "1 or 1=1");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user where id = ?");
        preparedStatement.setString(1, "1 or 1=1");
        ResultSet resultSet2 = preparedStatement.executeQuery();

        while (resultSet1.next()) {
            System.out.println(resultSet1.getString(1));
            System.out.println(resultSet1.getString(2));
            System.out.println(resultSet1.getString(3));
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        while (resultSet2.next()) {
            System.out.println(resultSet2.getString(1));
            System.out.println(resultSet2.getString(2));
            System.out.println(resultSet2.getString(3));
        }

    }

}
