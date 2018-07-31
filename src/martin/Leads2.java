package martin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Leads2 {

    Connection con, con2, con3;
    PreparedStatement psmtselect, psmtupdate, psmtselector, psmtinsertdata;
    ResultSet rs, rs2;
    int id;
    String username;
    String password;
    String agent;
    int max_daily;
    int max_weekly;
    int max_monthly;
    int max_total;
    Date start_date;
    Date end_date;
    int logged_in;
    Date logged_in_time;
    String msg;
    String destination_addr;
    String admin;
    String short_codes;
    Date last_received;
    Date last_send;
    int last_received_id;
    int last_sent_id;
    int sms_count_today;
    int sms_count_week;
    int sms_count_month;
    int sms_count_total;
    int received_total;
    int received_month;
    int received_week;
    int received_today;
    String name;
    String contact_number;
    String contract_num;
    String taskadmin;
    String surname;
    String firstname;
    String email_address;
    Date date_updated;
    String organization;
    byte enable_email_alert;
    int alertThreshold;
    int alerted;
    int super_account_id;
    int arrears;
    float cost_per_sms;
    int onlinesignupstatus;

    String queryselect = "SELECT id,username,password,agent,max_daily,max_weekly,max_monthly,max_total,start_date,end_date,logged_in,logged_in_time,msg,destination_addr,admin,short_codes,last_received,last_send,last_received_id,last_sent_id,sms_count_today,sms_count_week,sms_count_month,sms_count_total,received_total,received_month,received_week,received_today,name,contact_number,contract_num,taskadmin,surname,firstname,email_address,date_updated,organization,enable_email_alert,alertThreshold,alerted,super_account_id,arrears,cost_per_sms FROM tUSER where agent='onlinesignup'";
    String query = "INSERT INTO tUSER_All_Data(id,username,password,agent,max_daily,max_weekly,max_monthly,max_total,start_date,end_date,logged_in,logged_in_time,msg,destination_addr,admin,short_codes,last_received,last_send,last_received_id,last_sent_id,sms_count_today,sms_count_week,sms_count_month,sms_count_total,received_total,received_month,received_week,received_today,name,contact_number,contract_num,taskadmin,surname,firstname,email_address,date_updated,organization,enable_email_alert,alertThreshold,alerted,super_account_id,arrears,cost_per_sms)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String querydata = "SELECT * FROM tUSER_All_Data where onlinesignupstatus=0";
    String queryupdate = "UPDATE tUSER_All_Data set onlinesignupstatus=1 where id=?";

    jdbcUtils utils = new jdbcUtils();

    public Leads2() {
        fetchDataToCopy();
        try {

            con3 = utils.Server45();
            psmtselect = con3.prepareStatement(querydata);
            psmtupdate = con3.prepareStatement(queryupdate);
            rs = psmtselect.executeQuery();

            while (rs.next()) {
                username = rs.getString("username");
                start_date = rs.getDate("start_date");
                contact_number = rs.getString("contact_number");
                surname = rs.getString("surname");
                firstname = rs.getString("firstname");
                organization = rs.getString("organization");

                String me = "0718XXXXXX";
                String davis="0720XXXXXX",rose="0720XXXXXX",beatrice="0720XXXXXX",rahab="0720XXXXXX",emily="0720XXXXXX",edinah="0720XXXXXX";
                int id = rs.getInt("id");
                //Below are details to be read by the schedule application, note tab separator which helps the schedule system to know destination
                //, message and sender id
                updateLeads(id);
                System.out.println(me + "\tHi Martin, you have a new sign-up lead : Contact " + contact_number + " Organization: " + organization + " Name: " + surname + " " + firstname + " Time: " + start_date + "\tMSpace");
                System.out.println(davis + "\tHi Davis, you have a new sign-up lead : Contact " + contact_number + " Organization: " + organization + " Name: " + surname + " " + firstname + " Time: " + start_date + "\tMSpace");
                System.out.println(beatrice + "\tHi Beatrice, you have a new sign-up  lead : Contact " + contact_number + " Organization: " + organization + " Name: " + surname + " " + firstname + " Time: " + start_date + "\tMSpace");
                System.out.println(emily + "\tHi Emily, you have a new sign-up lead : Contact " + contact_number + " Organization: " + organization + " Name: " + surname + " " + firstname + " Time: " + start_date + "\tMSpace");
                System.out.println(edinah + "\tHi Edinah,you have a new sign-up lead : Contact " + contact_number + " Organization: " + organization + " Name: " + surname + " " + firstname + " Time: " + start_date + "\tMSpace");
                                System.out.println(rahab + "\tHi Rahab,you have a new sign-up lead : Contact " + contact_number + " Organization: " + organization + " Name: " + surname + " " + firstname + " Time: " + start_date + "\tMSpace");

                                                System.out.println(rose + "\tHi Rose,you have a new sign-up lead : Contact " + contact_number + " Organization: " + organization + " Name: " + surname + " " + firstname + " Time: " + start_date + "\tMSpace");

            }

            //Always remember to close your connection!!!!!
            con3.close();

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
      //  System.out.println("====================================NEW LEAD PROCESSED SUCCESSFULLY====================================");

    }

    private void fetchDataToCopy() {
        try {
            con2 = utils.ReplicationServer();
            psmtselector = con2.prepareStatement(queryselect);
            rs2 = psmtselector.executeQuery();
            con = utils.Server45();
            psmtinsertdata = con.prepareStatement(query);
            while (rs2.next()) {
                id = rs2.getInt("id");
                username = rs2.getString("username");
                password = rs2.getString("password");
                agent = rs2.getString("agent");
                max_daily = rs2.getInt("max_daily");
                max_weekly = rs2.getInt("max_weekly");
                max_monthly = rs2.getInt("max_monthly");
                max_total = rs2.getInt("max_total");
                start_date = rs2.getDate("start_date");
                end_date = rs2.getDate("end_date");
                logged_in = rs2.getInt("logged_in");
                logged_in_time = rs2.getDate("logged_in_time");
                msg = rs2.getString("msg");
                destination_addr = rs2.getString("destination_addr");
                admin = rs2.getString("admin");
                short_codes = rs2.getString("short_codes");
                last_received = rs2.getDate("last_received");
                last_send = rs2.getDate("last_send");
                last_received_id = rs2.getInt("last_received_id");
                last_sent_id = rs2.getInt("last_sent_id");
                sms_count_today = rs2.getInt("sms_count_today");
                sms_count_week = rs2.getInt("sms_count_week");
                sms_count_month = rs2.getInt("sms_count_month");
                sms_count_total = rs2.getInt("sms_count_total");
                received_total = rs2.getInt("received_total");
                received_month = rs2.getInt("received_month");
                received_week = rs2.getInt("received_week");
                received_today = rs2.getInt("received_today");
                name = rs2.getString("name");
                contact_number = rs2.getString("contact_number");
                contract_num = rs2.getString("contract_num");
                taskadmin = rs2.getString("taskadmin");
                surname = rs2.getString("surname");
                firstname = rs2.getString("firstname");
                email_address = rs2.getString("email_address");
                date_updated = rs2.getDate("date_updated");
                organization = rs2.getString("organization");
                enable_email_alert = rs2.getByte("enable_email_alert");
                alertThreshold = rs2.getInt("alertThreshold");
                alerted = rs2.getInt("alerted");
                super_account_id = rs2.getInt("super_account_id");
                arrears = rs2.getInt("arrears");
                cost_per_sms = rs2.getFloat("cost_per_sms");
                try{
                psmtinsertdata.setInt(1, id);
                psmtinsertdata.setString(2, username);
                psmtinsertdata.setString(3, password);
                psmtinsertdata.setString(4, agent);
                psmtinsertdata.setInt(5, max_daily);
                psmtinsertdata.setInt(6, max_weekly);
                psmtinsertdata.setInt(7, max_monthly);
                psmtinsertdata.setInt(8, max_total);
                psmtinsertdata.setDate(9, start_date);
                psmtinsertdata.setDate(10, end_date);
                psmtinsertdata.setInt(11, logged_in);
                psmtinsertdata.setDate(12, logged_in_time);
                psmtinsertdata.setString(13, msg);
                psmtinsertdata.setString(14, destination_addr);
                psmtinsertdata.setString(15, admin);
                psmtinsertdata.setString(16, short_codes);
                psmtinsertdata.setDate(17, last_received);
                psmtinsertdata.setDate(18, last_send);
                psmtinsertdata.setInt(19, last_received_id);
                psmtinsertdata.setInt(20, last_sent_id);
                psmtinsertdata.setInt(21, sms_count_today);
                psmtinsertdata.setInt(22, sms_count_week);
                psmtinsertdata.setInt(23, sms_count_month);
                psmtinsertdata.setInt(24, sms_count_total);
                psmtinsertdata.setInt(25, received_total);
                psmtinsertdata.setInt(26, received_month);
                psmtinsertdata.setInt(27, received_week);
                psmtinsertdata.setInt(28, received_today);
                psmtinsertdata.setString(29, name);
                psmtinsertdata.setString(30, contact_number);
                psmtinsertdata.setString(31, contract_num);
                psmtinsertdata.setString(32, taskadmin);
                psmtinsertdata.setString(33, surname);
                psmtinsertdata.setString(34, firstname);
                psmtinsertdata.setString(35, email_address);
                psmtinsertdata.setDate(36, date_updated);
                psmtinsertdata.setString(37, organization);
                psmtinsertdata.setByte(38, enable_email_alert);
                psmtinsertdata.setInt(39, alertThreshold);
                psmtinsertdata.setInt(40, alerted);
                psmtinsertdata.setInt(41, super_account_id);
                psmtinsertdata.setInt(42, arrears);
                psmtinsertdata.setFloat(43, cost_per_sms);
                psmtinsertdata.executeUpdate();
                }
                catch(SQLException ex)
                {
                   if (ex.getMessage().contains("Duplicate entry")) {
                
            } else {
                ex.printStackTrace();
            } 
                }
            }

            con.close();
           // System.out.println("===================== Disconnected from Server 45  ===============================");
            con2.close();
           // System.out.println("===================== Disconnected from Replication Server =======================");
        } catch (SQLException ex) {
           
                ex.printStackTrace();
            
        }
    }

    public static void main(String[] args) {
        //Call the constructor to run the code
        new Leads2();
    }
}
