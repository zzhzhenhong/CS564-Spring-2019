import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class pgtest{
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://stampy.cs.wisc.edu/cs564instr?sslfactory=org.postgresql.ssl.NonValidatingFactory&ssl";
        Connection conn = DriverManager.getConnection(url);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select count(*) from hw2.sales");
        while (rs.next()) {
            System.out.print("Row returned: ");
            System.out.println(rs.getInt(1));
        }
        // close up shop
        rs.close();
        st.close();
        conn.close();
    } }