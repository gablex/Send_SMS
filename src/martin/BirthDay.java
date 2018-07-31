
package martin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BirthDay {

    Connection con = null;
    PreparedStatement psmt = null;
    ResultSet rs;
    String mobile = "";
    String name = "";

    String query = "select  mobile as mobile , CONCAT(fname,\" \", lname) as name from tSTAFF_Martin WHERE MONTH(dob)=MONTH(CURRENT_DATE()) AND DAY(dob)=DAY(CURRENT_DATE())";

    public BirthDay() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://Server:3306/database", "user", "passwd");
            psmt = con.prepareStatement(query);
            rs = psmt.executeQuery();

            while (rs.next()) {
                mobile = rs.getString("mobile");
                name = rs.getString("name");

                System.out.println(mobile + "\tDear " + name + " Happy Birthday\t MSpace");

            }

            //Always remember to close your connection!!!!!
            con.close();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }

        System.exit(0);

    }

    public static void main(String[] args) {
        new BirthDay();

    }
}
