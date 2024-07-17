
package library.managment.system;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleDriver;


public class LibraryManagmentSystem {
    

    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
//        Random r = new Random();
//        int max = 55555;
//        int min = 99999;
//        Connection c = null;
//        Statement s = null;
//          try {
//            c = connect();
//            s = c.createStatement();
//            ResultSet    rs   = s.executeQuery("select distinct email from issus_book  ib join students s on(ib.student_id = s.id) where round(RETURN_DATE-sysdate) < 3 and  round(RETURN_DATE-sysdate) != 0");
//            while(rs.next()){
//          int b = (int)(Math.random()*(max-min+1)+min);
//          final String fromEmail =  "mohamednabil5011@gmail.com";   //user.getFromEmail(); //requires valid gmail id
//          final String password =   "dcnsivlscwmtzwxg";           //user.getPassword(); // correct password for gmail id
//          final String toEmail =    rs.getString(1); // can be any email id 
//          Properties props = new Properties();
//          props.put("mail.smtp.host", "smtp.gmail.com");  //SMTP Host
//          props.put("mail.smtp.port", "587");             //TLS Port
//          props.put("mail.smtp.auth", "true");            //enable authentication
//          props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
//          Session session = Session.getDefaultInstance(props,null);
//          MimeMessage msg = new MimeMessage(session);
//          //set message headers
//          msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//          msg.addHeader("format", "flowed");
//          msg.addHeader("Content-Transfer-Encoding", "8bit");
//          msg.setReplyTo(InternetAddress.parse(fromEmail, false));
//          msg.setSubject("Reset password", "UTF-8");
//          msg.setFrom(new InternetAddress(fromEmail, "Integrated Library System"));
//          msg.setText("Hi "+toEmail+" ,\n" +
//"We just need to verify your email address before you can change password.\n" +
//"\n" +
//"Your verification code : "+ b +"\n" +
//"\n" +
//"Thanks! – The Integrated Library System team","UTF-8");
//          msg.setSentDate(new Date());
//          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//          System.out.println("Message is ready");
//          Transport trans=session.getTransport("smtp");
//          trans.connect("smtp.gmail.com",fromEmail,password);
//          trans.sendMessage(msg,msg.getAllRecipients());
//          System.out.println("EMail Sent Successfully!!");
//               
//            }
//          } catch (SQLException ex) {
//              System.out.println("ERROR");
//        }finally{
//            try {
//                s.close();
//                c.close();
//            } catch (Exception ex) {
//                System.out.println("ERROR");
//            }
//        }
//try { 
//            String query = "import hashlib\n" +
//"hashvalue = \"99771\"\n" +
//"hashobject = hashlib.sha1()\n" +
//"hashobject.update(hashvalue.encode())\n" +
//"print(hashobject.hexdigest())";
//            String file  = "Week1.py";
//            FileWriter fw = new LibraryManagmentSystem().fileWriter(file);
//            BufferedWriter bw = new LibraryManagmentSystem().bufferedWriter(fw);
//            bw.write(query);
//            bw.close();
//            fw.close();
//        } catch (IOException ex) {
//            System.out.println("Error ");
//        }
//        
//        try {
//            
//            // Specify the command to execute the Python script.
//            // The 'python3' command assumes Python 3.x is installed.
//            // Adjust it to 'python' or 'python2' if you are using Python 2.x.
//            String[] command = {"python3", "Week1.py"};
//            // Create the ProcessBuilder and set the command to execute.
//            ProcessBuilder pb = new ProcessBuilder(command);
////            // Redirect the error stream to the standard output stream (optional).
//            pb.redirectErrorStream(true);
////            // Start the process.
//            Process process = pb.start();
////            // Read the output from the process and display it.
////            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
////            String line;
////            while ((line = reader.readLine()) != null) {
////                System.out.println(line);
////            }
////            reader.close();
////            process.destroyForcibly();
//        } catch (Exception e ) {
//            System.out.println("error in compiler");
//        }

     
        
        String smtpUsername = "mohamednabil5011@gmail.com";
        String smtpPassword = "dcnsivlscwmtzwxg";
        String toPhoneNumber = "mohamednabil5011@gmail.com";        // This should be the email-to-SMS gateway address
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //SMTP Host
        props.put("mail.smtp.port", "587");             //TLS Port
        props.put("mail.smtp.auth", "true");            //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        props.put("mail.smtp.ssl.trust", "*");
        Session session = Session.getInstance(props, null);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mohamednabil5011@gmail.com")); // Replace with your email address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toPhoneNumber));
            message.setSubject("SMS Subject");
            message.setText("Hello, this is an SMS message!");

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", smtpUsername, smtpPassword);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("SMS sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
//        try {
//            String command = "import hashlib\n" +
//            "hashvalue = '99771' \n" +
//            "hashobject = hashlib.sha1()\n" +
//            "hashobject.update(hashvalue.encode())\n" +
//            "print(hashobject.hexdigest())";
//            BufferedWriter out = new BufferedWriter(new FileWriter("week1.py"));
//            out.write(command); 
//            out.close();
//            Process p = Runtime.getRuntime().exec("python week1.py");
//            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            String ret = in.readLine();
//            System.out.println("value is : "+ret);
//            
//        } catch (IOException ex) {
//            Logger.getLogger(LibraryManagmentSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//        int x[] = {2,3,4,5,91290,187,1037,160};
//        int temp;
//        for(int i =0 ; i<x.length;i++){
//            for(int j = i+1 ; j<x.length ; j++){
//                if(x[i]>x[j]){
//                    temp = x[j];
//                    x[j] = x[i];
//                    x[i] = temp;
//                }
//         }   
//        }
//        for(int i =0 ; i<x.length;i++){
//            System.out.println(x[i]);   
//        }
        
    }
public static Connection connect() throws SQLException{
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "mica";
    String password = "mica";
    DriverManager.registerDriver(new OracleDriver());
    Connection c = DriverManager.getConnection(url, user, password);
    return c;
}
public static FileReader fileReader(String file) throws IOException{
                File            f = new File(file);
                FileReader     fr = new FileReader(f);
                return fr; 
    }
    public static BufferedReader bufferedReader(FileReader fr) throws IOException{
                BufferedReader br = new BufferedReader(fr);
                return br; 
    }
    
    public static FileWriter fileWriter(String file) throws IOException{
                File            f = new File(file);
                FileWriter     fw = new FileWriter(f);
                return fw; 
    }
    public static BufferedWriter bufferedWriter(FileWriter fw) throws IOException{
                BufferedWriter bw = new BufferedWriter(fw);
                return bw;
    }

}
