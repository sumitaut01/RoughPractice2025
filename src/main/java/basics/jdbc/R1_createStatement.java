package basics.jdbc;


import java.sql.*;

// we directly have the sql here.. considered unsafe for sql injection
public class R1_createStatement {
    public static String dbString = "jdbc:postgres://someurl:port/dbName";
    public static String dbUsername = "someUsername";
    public static String dbPassword = "somePassword";

    public static String query1 = "select * from  employee";


    public static void main(String[] args) {
//Using Statement (simple SQL, unsafe)
//💡 When to use:
//For static SQL queries (no parameters)
//For quick tests, DDLs (create, drop), etc.
//❌ Not safe for dynamic user input (risk of SQL injection)

        //best practice to use try with resources

        try (
                Connection con = DriverManager.getConnection(dbString, dbUsername, dbPassword);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query1)
        ) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("dept") + " | " +
                                rs.getDouble("salary")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
