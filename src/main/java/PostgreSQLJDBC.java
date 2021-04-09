import com.fasterxml.jackson.databind.ObjectMapper;
import org.postgresql.util.PSQLException;

import java.io.File;
import java.sql.*;

public class PostgreSQLJDBC {

    //  Database credentials
    static Emp emp = new Emp("","","");
    static final String DB_URL = "jdbc:postgresql://localhost:5432/test";
    static final String USER = "postgres";
    static final String PASS = "postgres";
    public static String Obj = "";

    public static void main(String[] argv) {
        Statement stmt = null;

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC Driver successfully connected");
            Connection connection = null;

//select row_to_json(t)  from(select * from cars) as t

            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = connection.createStatement();
            String sql = "select * from cars";
            ObjectMapper objectmapper = new ObjectMapper();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Получаем значения
                emp.setId(rs.getString("id"));
                emp.setName(rs.getString("name"));
                emp.setTariff(rs.getString("tariff"));

                String result = objectmapper.writeValueAsString(emp);
                System.out.println(result);

            }
            stmt.close();
            connection.close();

            if (connection != null) {
                System.out.println("You successfully connected to database now");
            } else {
                System.out.println("Failed to make connection to database");
            }
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}