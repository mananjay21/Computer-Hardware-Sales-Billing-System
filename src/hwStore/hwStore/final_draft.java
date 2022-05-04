package hwStore;
import java.sql.*;
import java.util.Scanner;
public class final_draft {
    public static String url="jdbc:postgresql://localhost:5432/example";
    public static String id="postgres";
    public static String pass="9674";
    public static boolean login=false;
    public static void main(String args[]) {
        DBoperation_usr usr=new DBoperation_usr();
        DBoperation_admin adm=new DBoperation_admin();
        try
        {
        Connection conn=DriverManager.getConnection(url, id, pass);
        Statement stmt1= conn.createStatement();
        Scanner s=new Scanner(System.in);
        String type;
        System.out.println("entr type of user (admin or user)");
        type=s.next();
        System.out.println("entr uname");
        String u_name=s.next();
        System.out.println("entr pass");
        String p_word=s.next();
        validate v=new validate();
        login=v.check(type, u_name, p_word);
        if(login)
        {}
        else
        {
            addUser au=new addUser();
            au.newUser(u_name, pass);
        }

/*           switch for user            */


        int x;
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
                        int id=s.nextInt();
                        usr.addItem(id);
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
                        int bill_id=s.nextInt();
                        usr.removeItem(bill_id);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                       break;
                    }
                    case 3:
                    {
                        usr.view();
                        break;
                    }
                    case 4:
                    {
                        usr.checkOut();
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
                       int id,price;
                        String name;
                        System.out.println("insert id.no (must be unique)");
                        id=s.nextInt();
                        System.out.println("insert name");
                        name=s.next();
                        System.out.println("insert price");
                        price=s.nextInt();
                        adm.addProduct(id, name, price);
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
                       int id=s.nextInt();
                       adm.removeProduct(id);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                       break;
                    }
                    case 3:
                    {
                        adm.view();
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
                        int id=s.nextInt();
                        int price=s.nextInt();
                        adm.manageProduct(id, price);
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
