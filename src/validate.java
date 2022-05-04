package hwStore;
import java.sql.*;
public class validate {
    public static String url="jdbc:postgresql://localhost:5432/example";
    public static String id="postgres";
    public static String pass="9674";
    public boolean check(String type,String u_name,String p_word)
    {
        try
        {
            Connection conn=DriverManager.getConnection(url, id, pass);
            Statement stmt1= conn.createStatement();
            if((type.equalsIgnoreCase("user")))
            {ResultSet r=stmt1.executeQuery("select *from users");
            while(r.next())
            {
                if((u_name.equals(r.getString("username"))))
                {
                    if(p_word.equals(r.getObject("password")))
                    {
                        System.out.println("logged in");
                        return true;
                    }
                    else{
                        System.out.println("incorrect password");
                    }
                }
            }
        } 
        else if((type.equalsIgnoreCase("admin")))
        {
            ResultSet r=stmt1.executeQuery("select *from admins");
            while(r.next())
            {
                if((u_name.equals(r.getString("username"))))
                {
                    if(p_word.equals(r.getObject("password")))
                    {
                        System.out.println("logged in");
                        return true;
                    }
                    else{
                        System.out.println("incorrect password");
                    }
                }
            }
        }
        else
        {
            System.out.println("invalid input");
        }
    }
    catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
