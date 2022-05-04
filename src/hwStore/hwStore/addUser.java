package hwStore;

import java.sql.*;
public class addUser {
    public static String url="jdbc:postgresql://localhost:5432/example";
    public static String id="postgres";
    public static String pass="9674";
    public void newUser(String u_name,String p_word)
    {
        try {
            Connection conn=DriverManager.getConnection(url, id, pass);
            Statement stmt1= conn.createStatement();
            ResultSet r=stmt1.executeQuery("select *from admins");
            while(r.next())
            {
                if((u_name.equals(r.getString("username"))))
                {
                    System.out.println("User already exist");
                }
                else
                {
                    PreparedStatement stmt=conn.prepareStatement("INSERT INTO users values (?,?)");
                    stmt.setString(1, u_name);
                    stmt.setString(2, p_word);
                    System.out.println("User added successfully");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
       
    }
}
