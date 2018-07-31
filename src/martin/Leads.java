package martin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*Code to test scheduling in mspace. Author: Martin Director: Davis Shuma*/
public class Leads {

    Connection con;
    PreparedStatement psmtselect, psmtupdate;
    ResultSet rs;
    String mobile, email, message, recepient;
    Date date;
    //Select leads for the last one hour
    String queryselect = "SELECT id,mobile, email, msg, dbDate FROM tCONTACTUSNESMS where status=0";
    String queryupdate = "update tCONTACTUSNESMS set status=1 where id=?";
    jdbcUtils utils = new jdbcUtils();

    public Leads() {
        try {

            con = utils.connectionGodaddy();
            psmtselect = con.prepareStatement(queryselect);
            psmtupdate = con.prepareStatement(queryupdate);

            rs = psmtselect.executeQuery();

            while (rs.next()) {
                mobile = rs.getString("mobile");
                email = rs.getString("email");
                message = rs.getString("msg");
                date = rs.getDate("dbDate");
                recepient = "0720XXXXXX";
                int id=rs.getInt("id");
                String davis="0720XXXXXX",rose="0720XXXXXX",beatrice="0720XXXXXX",rahab="0720XXXXXX",emily="0720XXXXXX",edinah="0720XXXXXX";
                
                //Below are details to be read by the schedule application, note tab separator which helps the schedule system to know destination
                //, message and sender id
                System.out.println(recepient + "\tHi Martin, Someone has just contacted us.  Phone: " + mobile + " Email: " + email + " Message: " + message + " Time: " + date + "\tMSpace");
                System.out.println(davis + "\tHi Davis, Someone has just contacted us.Phone: " + mobile + " Email: " + email + " Message: " + message + " Time: " + date + "\tMSpace");
                                System.out.println(beatrice + "\tHi Beatrice, Someone has just contacted us. Phone: " + mobile + " Email: " + email + " Message: " + message + " Time: " + date + "\tMSpace");
                                                System.out.println(emily + "\tHi Emily, Someone has just contacted us. Phone: " + mobile + " Email: " + email + " Message: " + message + " Time: " + date + "\tMSpace");
                                                 System.out.println(edinah + "\tHi Edinah, Someone has just contacted us. Phone: " + mobile + " Email: " + email + " Message: " + message + " Time: " + date + "\tMSpace");
                                                 System.out.println(rahab + "\tHi Rahab, Someone has just contacted us. Phone: " + mobile + " Email: " + email + " Message: " + message + " Time: " + date + "\tMSpace");
                                                 System.out.println(rose + "\tHi Rose, Someone has just contacted us. Phone: " + mobile + " Email: " + email + " Message: " + message + " Time: " + date + "\tMSpace");

                updateLeads(id);

            }

            //Always remember to close your connection!!!!!
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        System.exit(0);

    }

    private void updateLeads(int a) throws SQLException {
        /*we avoid running preparedstatement multiple times by calling it once and clearing parameters here
        this helps us save resources as we use mysql since we only call connection to database once*/

        psmtupdate.clearParameters();
        psmtupdate.setInt(1, a);
        psmtupdate.executeUpdate();
        System.out.println("=============================================================NEW LEAD PROCESSED SUCCESSFULLY==========================================");

    }

    public static void main(String[] args) {
        //Call the constructor to run the code
        new Leads();
    }
}
