package basics.jdbc;


//considered safe as it can avoid sql injection

import java.sql.*;

public class R2_prepareStatement {
    public static String dbString = "jdbc:postgres://someurl:port/dbName";
    public static String dbUsername = "someUsername";
    public static String dbPassword = "somePassword";

    public static String query1 = "select * from  employee";

    public static String query2 = "select * from  employee where id=?";


    public static Connection con = null;


    public static void main(String[] args) throws SQLException {
        //Assume we have below structure
        //CREATE TABLE employee (
        //    id SERIAL PRIMARY KEY,
        //    name VARCHAR(100),
        //    dept VARCHAR(50),
        //    salary NUMERIC(10,2)
        //);

//        Step 5: Using PreparedStatement (safe, parameterized)
//💡 When to use:
//        Whenever you have dynamic data (user input, parameters)
//        Prevents SQL injection
//        Improves performance for repeated queries
//        Example 1 — Insert data

        String insert = "INSERT INTO employee (name, dept, salary) VALUES (?, ?, ?)";


        try (Connection con = DriverManager.getConnection("", "", "");
             PreparedStatement ps = con.prepareStatement(insert)) {
            ps.setString(1, "Amit");
            ps.setString(2, "QA");
            ps.setDouble(3, 75000.0);

            int rows = ps.executeUpdate();
            System.out.println(rows + " record(s) inserted.");
        } catch (Exception e) {


        }


//                ✅ Output:
//                1record(s)inserted.
//                Example 2 — Read data with a condition
        String query = "SELECT * FROM employee WHERE dept = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, "QA");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("name") + " | " + rs.getDouble("salary"));
        }


//                ✅ Output:
//
//                Amit|75000.0
//                Sumit|85000.0
//
//                Example 3 — Update data
        String update = "UPDATE employee SET salary = ? WHERE id = ?";
        ps = con.prepareStatement(update);

        ps.setDouble(1, 95000.0);
        ps.setInt(2, 2);

        int rows = ps.executeUpdate();
        System.out.println(rows + " record(s) updated.");

//                Example 4 — Delete data
        String delete = "DELETE FROM employee WHERE id = ?";
        ps = con.prepareStatement(delete);
        ps.setInt(1, 3);
        ps.executeUpdate();
//
//                🔹 Step 6:Differences Between Statement and PreparedStatement
//                Feature Statement PreparedStatement
//                SQL syntax Static Dynamic(parameterized)
//                Performance Slower for repeated queries Faster(precompiled SQL)
//                Safety    ❌ Prone to SQL Injection    ✅ Prevents SQL Injection
//                Parameter binding    ❌ Not supported    ✅ ?placeholders
//                Use case DDLs,fixed queries CRUD ops with user input
    }
}
