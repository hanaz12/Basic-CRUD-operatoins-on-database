import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
    static Connection con;

    public static Connection createDBConnection() throws ClassNotFoundException {
        try {
            // Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //get connection
            String url = "jdbc:mysql://localhost:3306/employee?useSSL=false" ;
            String username = "root" ;
            String password = "rootrootroot" ;
            con = DriverManager.getConnection(url, username, password);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}