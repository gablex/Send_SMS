/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package martin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author support
 */
public class Leads3 {
    //Sends notification when a new user sign-up for bulk sms
     Connection con;
    PreparedStatement psmtselect, psmtupdate;
    ResultSet rs;
    String firstname,lastname,email,phone,company,website, service;
    Date start_date;
    //Select leads for the last one hour
    String queryselect = "SELECT id,firstname,lastname,email,phone,company,website, service FROM tDEMO where status=0";
    String queryupdate = "update tDEMO set status=1 where id=?";
    jdbcUtils utils = new jdbcUtils();

    public Leads3() {
        try {

            con = utils.connectionGodaddy();
            psmtselect = con.prepareStatement(queryselect);
            psmtupdate = con.prepareStatement(queryupdate);

            rs = psmtselect.executeQuery();

            while (rs.next()) {
                firstname= rs.getString("firstname");
                lastname = rs.getString("lastname");
                email= rs.getString("email");
                phone=rs.getString("phone");
                company=rs.getString("company");
                website=rs.getString("website");
                service=rs.getString("service");
               
                String me = "0718XXXXXX";
                String davis="0720XXXXXX",rose="0720XXXXXX",beatrice="0720XXXXXX",rahab="0720XXXXXX",emily="0720XXXXXX",edinah="0720XXXXXX";
                int id = rs.getInt("id");
                //Below are details to be read by the schedule application, note tab separator which helps the schedule system to know destination
                //, message and sender id
                System.out.println(me + "\tHi Martin, You've a new DEMO request : Contact " + phone + " Organization: " + company + " Name: " + firstname +" " +lastname+ " Email: " + email + "Website: "+website+"Service: "+service+"\tMSpace");
                System.out.println(davis + "\tHi Davis, You've a new DEMO request: Contact " + phone + " Organization: " + company + " Name: " + firstname +" " +lastname+ " Email: " + email + "Website: "+website+"Service: "+service+"\tMSpace");
                                System.out.println(beatrice + "\tHi Beatrice, You've a new DEMO request : Contact " + phone + " Organization: " + company + " Name: " + firstname +" " +lastname+ " Email: " + email + "Website: "+website+"Service: "+service+"\tMSpace");
                                                System.out.println(emily + "\tHi Emily, You have a new DEMO request : Contact " + phone + " Organization: " + company + " Name: " + firstname +" " +lastname+ " Email: " + email + "Website: "+website+"Service: "+service+"\tMSpace");
                System.out.println(edinah+"\tHi Edinah,You have a new DEMO request : Contact " + phone + " Organization: " + company + " Name: " + firstname +" " +lastname+ " Email: " + email + "Website: "+website+"Service: "+service+"\tMSpace");
                                System.out.println(rahab+"\tHi Rahab,You have a new DEMO request : Contact " + phone + " Organization: " + company + " Name: " + firstname +" " +lastname+ " Email: " + email + "Website: "+website+"Service: "+service+"\tMSpace");
                                System.out.println(rose+"\tHi Rose,You have a new DEMO request : Contact " + phone + " Organization: " + company + " Name: " + firstname +" " +lastname+ " Email: " + email + "Website: "+website+"Service: "+service+"\tMSpace");

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
        new Leads3();
    }
}
