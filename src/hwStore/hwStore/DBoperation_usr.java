package hwStore;

import java.sql.*;
import java.sql.SQLException;
public class DBoperation_usr {
    public static String url="jdbc:postgresql://localhost:5432/example";
    public static String id="postgres";
    public static String pass="9674";
    public Connection conn;
    public Statement stmt1;
    public DBoperation_usr()
    {
    try
        {
            conn=DriverManager.getConnection(url, id, pass);
            stmt1= conn.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void addItem(int id)
    {
                        try
                        {
                       PreparedStatement stmt=conn.prepareStatement("INSERT INTO bill (id,p_name,price) SELECT * FROM product where id=?");
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
    }
    public void removeItem(int bill_id)
    {
        try
                        {
                            PreparedStatement stmt=conn.prepareStatement("delete from bill where bill_id=?");
                        System.out.println("\nentr the bill_id to delete");
                        stmt.setInt(1, bill_id);
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
    }
    public void view()
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
    }
    public void checkOut()
    {
        System.out.printf("%40s","YOUR BILL\n\n");
                        try {
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
                    } catch (SQLException e) 
                    {
                        System.out.println(e);
                    }
    }
}
