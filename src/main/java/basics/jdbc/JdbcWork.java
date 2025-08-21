package basics.jdbc;

import java.sql.*;

public class JdbcWork {
    public static void main(String[] args) throws SQLException {


        String stmt = "select * from employees";
        Connection con = DbUtil.getConnection("postgres");

        PreparedStatement preparedStatement = con.prepareStatement(stmt);
        ResultSet rs = preparedStatement.executeQuery();//for select

        while (rs.next()) {
            System.out.println(rs.getString("name"));
            //id|name   |department_id|salary|
            //--+-------+-------------+------+
            // 1|Alice  |            1| 70000|
            // 2|Bob    |            1| 75000|
            // 3|Charlie|            2| 60000|
        }


        rs.close();
        preparedStatement.close();
        con.close();


    }


}


class DbUtil {
    public static Connection getConnection(String dbType) {
        if (dbType.equalsIgnoreCase("postgres")) {
            try {
                return DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "pass"
                );
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

}
