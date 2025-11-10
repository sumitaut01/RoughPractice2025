package basics.jdbc;

public class R3_SqlInjectionProblem {

    //Step 7: Example — SQL Injection Problem
    //❌ Using Statement:
    //
    //String dept = "QA' OR '1'='1";
    //String query = "SELECT * FROM employee WHERE dept = '" + dept + "'";
    //ResultSet rs = stmt.executeQuery(query);
    //➡️ This query becomes:
    //
    //SELECT * FROM employee WHERE dept = 'QA' OR '1'='1';
    //
    //and returns all employees — injected!
    //
    //✅ Using PreparedStatement fixes this:
    //PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE dept = ?");
    //ps.setString(1, dept);
    //
    //Here, 'QA' OR '1'='1' is treated as plain text, not executable SQL.
    //
    //🔹 Step 8: Cleanup best practices
    //Always use try-with-resources for JDBC:
    //try (Connection con = DBUtil.getConnection();
    //     PreparedStatement ps = con.prepareStatement(sql);
    //     ResultSet rs = ps.executeQuery()) {
    //    ...
    //}
    //

    //It automatically closes all resources, even if an exception occurs.
    //✅ Step 9: Summary
    //Task	Recommended API	Example
    //Simple fixed SQL	Statement	stmt.executeQuery("SELECT * FROM emp")
    //Dynamic SQL with params	PreparedStatement	ps.setString(1, "QA")
    //Batch insert/update	PreparedStatement	ps.addBatch()
    //Prevent SQL Injection	✅ PreparedStatement	WHERE dept = ?
}
