import config.DbConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import views.Front;

/**
 * A Swing CRUD application
 * @author Cogent
 */
public class SwingCrud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Front Front = new Front();
        Front.setVisible(true);
        
//        testJdbcOperation();
        DbConfig.closeConnection();
    }

    private static void testJdbcOperation() throws SQLException {
        Connection conn = DbConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from library");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            System.out.println("Id: " + rs.getObject(1));
            System.out.println("Name: " + rs.getObject(2));
        }
        DbConfig.closeStatement(stmt, rs);
    }
    
}
