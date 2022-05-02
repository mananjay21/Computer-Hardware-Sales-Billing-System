import java.sql.*;
import java.util.Scanner;
public class final_draft {
    public static String url="jdbc:postgresql://localhost:5432/example";
    public static String id="postgres";
    public static String pass="9674";
    public static boolean login=false;
    public static int x;
    public static void main(String args[]) {
        try
        {
            Connection conn=DriverManager.getConnection(url, id, pass);
            Statement stmt1= conn.createStatement();
        Scanner s=new Scanner(System.in);
        String type;
        System.out.println("entr type of user (admin or user)");
        type=s.next();
        try {
           String u,p;
            if((type.equalsIgnoreCase("user")))
            {
            System.out.println("entr uname");
            u=s.next();
            System.out.println("entr pass");
            p=s.next();
            ResultSet r=stmt1.executeQuery("select *from users");
            while(r.next())
            {
                if((u.equals(r.getString("username"))))
                {
                    if(p.equals(r.getObject("password")))
                    {
                        System.out.println("logged in");
                        login=true;
                    }
                    else{
                        System.out.println("incorrect password");
                    }
                }
            }
        } 
        else if((type.equalsIgnoreCase("admin")))
        {
            System.out.println("entr uname");
            u=s.next();
            System.out.println("entr pass");
            p=s.next();
            ResultSet r=stmt1.executeQuery("select *from admins");
            while(r.next())
            {
                if((u.equals(r.getString("username"))))
                {
                    if(p.equals(r.getObject("password")))
                    {
                        System.out.println("logged in");
                        login=true;
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


/*           switch for user            */


        if((type.equalsIgnoreCase("user")) && login==true)
        {
        for(;;)
            {
                System.out.println("\n1 add item");
                System.out.println("2 remove item");
                System.out.println("3 view cart");
                System.out.println("4 to exit");
                x=s.nextInt();
                switch(x)
                {
                    case 1:
                    {
                        try
                        {
                       PreparedStatement stmt=conn.prepareStatement("INSERT INTO bill (id,p_name,price) SELECT * FROM product where id=?");
                        stmt1.execute("select * from product");
                        ResultSet rs=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData = rs.getMetaData();
                        int count = rsMetaData.getColumnCount();
                        for(int i = 1; i<=count; i++) {
                           System.out.printf("%-20s",rsMetaData.getColumnName(i));
                        }
    	                while(rs.next())
    	               {
                          
                        System.out.println();
                        System.out.printf("%-20d%-20s%-20d",rs.getInt(1),rs.getString(2),rs.getInt(3));
                        System.out.println();
                          
    	               }
                        int id;
                        System.out.println("insert id.no");
                        id=s.nextInt();
                        stmt.setInt(1, id);
                        stmt.executeUpdate();
                        System.out.println("\n");
                        stmt1.execute("select * from bill");
                        ResultSet rs1=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                        int count1 = rsMetaData1.getColumnCount();
                        for(int i = 1; i<=count1; i++) {
                           System.out.printf("%-20s",rsMetaData1.getColumnName(i));
                        }
    	                while(rs1.next())
    	               {
                      
                        System.out.println();
                        System.out.printf("%-20d%-20d%-20s%-20d",rs1.getInt(1),rs1.getInt(2),rs1.getString(3),rs1.getInt(4));
                        System.out.println();
                        
    	               }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                        break;
                    }
                    case 2:
                    {
                        try
                        {
                            System.out.println("\nbefore deleting\n");
                        stmt1.execute("select * from bill");
                        ResultSet rs=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData = rs.getMetaData();
                        int count = rsMetaData.getColumnCount();
                        for(int i = 1; i<=count; i++) {
                           System.out.printf("%-20s",rsMetaData.getColumnName(i));
                        }
    	                while(rs.next())
    	               {
                          
                       System.out.println();
                        System.out.printf("%-20d%-20d%-20s%-20d",rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4));
                        System.out.println();
                          
    	               }
                        PreparedStatement stmt=conn.prepareStatement("delete from bill where bill_id=?");
                        System.out.println("\nentr the bill_id to delete");
                        stmt.setInt(1, s.nextInt());
                        stmt.executeUpdate();
                        System.out.println("\nafter deleting\n");
                        stmt1.execute("select * from bill");
                        ResultSet rs1=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                        int count1 = rsMetaData1.getColumnCount();
                        for(int i = 1; i<=count1; i++) {
                           System.out.printf("%-20s",rsMetaData1.getColumnName(i));
                        }
    	                while(rs1.next())
    	               {
                          
                       System.out.println();
                        System.out.printf("%-20d%-20d%-20s%-20d",rs1.getInt(1),rs1.getInt(2),rs1.getString(3),rs1.getInt(4));
                        System.out.println();
                          
    	               }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                       break;
                    }
                    case 3:
                    {
                        try
                        {
                            System.out.println("\n");
                        stmt1.execute("select * from bill");
                        ResultSet rs=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData1 = rs.getMetaData();
                        int count1 = rsMetaData1.getColumnCount();
                        for(int i = 1; i<=count1; i++) {
                           System.out.printf("%-20s",rsMetaData1.getColumnName(i));
                        }
    	                while(rs.next())
    	               {
                          
                       System.out.println();
                        System.out.printf("%-20d%-20d%-20s%-20d",rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4));
                        System.out.println();
                          
    	               }
                       }
                       catch(Exception e)
                       {
                           System.out.println(e);
                       }
                        break;
                    }
                    case 4:
                    {
                        System.out.printf("%40s","YOUR BILL\n\n");
                        stmt1.execute("select * from bill");
                        ResultSet rs=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData1 = rs.getMetaData();
                        int count1 = rsMetaData1.getColumnCount();
                        for(int i = 1; i<=count1; i++) {
                           System.out.printf("%-20s",rsMetaData1.getColumnName(i));
                        }
    	                while(rs.next())
    	               {
                          
                       System.out.println();
                       System.out.printf("%-20d%-20d%-20s%-20d",rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4));
                       System.out.println();
                          
    	               }
                       stmt1.execute("SELECT SUM(price) FROM bill;");
                       ResultSet rs1=stmt1.getResultSet();
    	                while(rs1.next())
    	               {
                       
                        System.out.println("\ttotal price = \t"+rs1.getInt(1));
                        
    	               }
                       stmt1.execute("truncate bill");
                       System.out.println("\t\tTHANK YOU FOR SHOPPING\t\t");
                       stmt1.execute("drop table bill");
                       stmt1.execute("create table bill(bill_id serial primary key,id int ,p_name varchar(50),price int )");
                        System.exit(0);
                    }
                   default:
                   {
                       System.out.println("invalid input");
                   }
                }
            }
        }



/*          switch for admin        */



else if((type.equalsIgnoreCase("admin")) && login==true)
        {
        for(;;)
            {
                System.out.println("\n1 add product");
                System.out.println("2 remove product");
                System.out.println("3 view list");
                System.out.println("4 manage product");
                System.out.println("5 to exit");
                x=s.nextInt();
                switch(x)
                {
                    case 1:
                    {
                        try
                        {
                            stmt1.execute("select * from product");
                        ResultSet rs1=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                        int count1 = rsMetaData1.getColumnCount();
                        for(int i = 1; i<=count1; i++) {
                           System.out.printf("%-20s",rsMetaData1.getColumnName(i));
                        }
    	                while(rs1.next())
    	               {
                          
                       System.out.println();
                        System.out.printf("%-20d%-20s%-20d",rs1.getInt(1),rs1.getString(2),rs1.getInt(3));
                        System.out.println();
                          
    	               }
                        PreparedStatement stmt=conn.prepareStatement("insert into product values(?,?,?)");
                        int id,price;
                        String name;
                        System.out.println("insert id.no (must be unique)");
                        id=s.nextInt();
                        stmt.setInt(1, id);
                        System.out.println("insert name");
                        name=s.next();
                        stmt.setString(2, name);
                        System.out.println("insert price");
                        price=s.nextInt();
                        stmt.setInt(3, price);
                        stmt.executeUpdate();
                        System.out.println("\n");
                        stmt1.execute("select * from product");
                        ResultSet rs=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData = rs.getMetaData();
                        int count = rsMetaData1.getColumnCount();
                        for(int i = 1; i<=count; i++) {
                           System.out.printf("%-20s",rsMetaData.getColumnName(i));
                        }
    	                while(rs.next())
    	               {
                          
                       System.out.println();
                       System.out.printf("%-20d%-20s%-20d",rs.getInt(1),rs.getString(2),rs.getInt(3));
                       System.out.println();
                          
    	               }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                        break;
                    }
                    case 2:
                    {
                        try
                        {
                           System.out.println("\nbefore deleting\n");
                        stmt1.execute("select * from product");
                        ResultSet rs=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData1 = rs.getMetaData();
                        int count1 = rsMetaData1.getColumnCount();
                        for(int i = 1; i<=count1; i++) {
                           System.out.printf("%-20s",rsMetaData1.getColumnName(i));
                        }
    	                while(rs.next())
    	               {
                          
                        System.out.println();
                        System.out.printf("%-20d%-20s%-20d",rs.getInt(1),rs.getString(2),rs.getInt(3));
                        System.out.println();
                          
    	               }
                        PreparedStatement stmt=conn.prepareStatement("delete from product where id=?");
                        System.out.println("\nentr the id to delete");
                        stmt.setInt(1, s.nextInt());
                        stmt.executeUpdate();
                        System.out.println("\nafter deleting\n");
                        stmt1.execute("select * from product");
                        ResultSet rs1=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData = rs1.getMetaData();
                        int count = rsMetaData1.getColumnCount();
                        for(int i = 1; i<=count; i++) {
                           System.out.printf("%-20s",rsMetaData.getColumnName(i));
                        }
    	                while(rs1.next())
    	               {
                          
                       System.out.println();
                       System.out.printf("%-20d%-20s%-20d",rs1.getInt(1),rs1.getString(2),rs1.getInt(3));
                       System.out.println();
                          
    	               }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                       break;
                    }
                    case 3:
                    {
                        try
                        {
                           System.out.println("\n");
                        stmt1.execute("select * from product");
                        ResultSet rs=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData1 = rs.getMetaData();
                        int count1 = rsMetaData1.getColumnCount();
                        for(int i = 1; i<=count1; i++) {
                           System.out.printf("%-20s",rsMetaData1.getColumnName(i));
                        }
    	                while(rs.next())
    	               {
                          
                       System.out.println();
                       System.out.printf("%-20d%-20s%-20d",rs.getInt(1),rs.getString(2),rs.getInt(3));
                       System.out.println();
                          
    	               }
                       }
                       catch(Exception e)
                       {
                           System.out.println(e);
                       }
                        break;
                    }
                    case 4:
                    {
                        try
                        {
                            System.out.println("\nbefore updating\n");
                        stmt1.execute("select * from product");
                        ResultSet rs=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData1 = rs.getMetaData();
                        int count1 = rsMetaData1.getColumnCount();
                        for(int i = 1; i<=count1; i++) {
                           System.out.printf("%-20s",rsMetaData1.getColumnName(i));
                        }
    	                while(rs.next())
    	               {
                          
                       System.out.println();
                       System.out.printf("%-20d%-20s%-20d",rs.getInt(1),rs.getString(2),rs.getInt(3));
                       System.out.println();
                          
    	               }
                        PreparedStatement stmt=conn.prepareStatement("UPDATE product SET price=? WHERE id=?;");
                        System.out.println("\nentr the id to update");
                        stmt.setInt(2, s.nextInt());
                        System.out.println("\nentr updated price");
                        stmt.setInt(1, s.nextInt());
                        stmt.executeUpdate();
                        System.out.println("\nafter deleting\n");
                        stmt1.execute("select * from product");
                        ResultSet rs1=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData = rs1.getMetaData();
                        int count = rsMetaData1.getColumnCount();
                        for(int i = 1; i<=count; i++) {
                           System.out.printf("%-20s",rsMetaData.getColumnName(i));
                        }
    	                while(rs1.next())
    	               {
                       
                      System.out.println();
                      System.out.printf("%-20d%-20s%-20d",rs1.getInt(1),rs1.getString(2),rs1.getInt(3));
                      System.out.println();
                          
    	               }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                       break;

                    }
                    case 5:
                    {
                        System.exit(0);
                    }
                   default:
                   {
                       System.out.println("invalid input");
                   }
                }
            }
        }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}
}
