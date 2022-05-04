package hwStore;

import java.sql.*;
class DBoperation_admin {
    public static String url="jdbc:postgresql://localhost:5432/example";
    public static String id="postgres";
    public static String pass="9674";
    public Connection conn;
    public Statement stmt1;
    public DBoperation_admin()
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
    public void addProduct(int id,String name,int price)
    {
        try
                        {
                            PreparedStatement stmt=conn.prepareStatement("insert into product values(?,?,?)");
                        stmt.setInt(1, id);
                        stmt.setString(2, name);
                        stmt.setInt(3, price);
                        stmt.executeUpdate();
                        System.out.println("\n");
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
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
    }
    public void removeProduct(int id)
    {
        try
                        {
                           PreparedStatement stmt=conn.prepareStatement("delete from product where id=?");
                        System.out.println("\nentr the id to delete");
                        stmt.setInt(1, id);
                        stmt.executeUpdate();
                        System.out.println("\nafter deleting\n");
                        stmt1.execute("select * from product");
                        ResultSet rs1=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData = rs1.getMetaData();
                        int count = rsMetaData.getColumnCount();
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
    }
    public void view()
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
    }
    public void manageProduct(int id,int price)
    {
        try
                        {
                            PreparedStatement stmt=conn.prepareStatement("UPDATE product SET price=? WHERE id=?;");
                        stmt.setInt(2, price);
                        stmt.setInt(1, id);
                        stmt.executeUpdate();
                        System.out.println("\nafter deleting\n");
                        stmt1.execute("select * from product");
                        ResultSet rs1=stmt1.getResultSet();
                        ResultSetMetaData rsMetaData = rs1.getMetaData();
                        int count = rsMetaData.getColumnCount();
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
    }
}
