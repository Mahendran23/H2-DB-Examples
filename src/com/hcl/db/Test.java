package com.hcl.db;
import java.io.PrintStream;
import java.sql.*;

import org.h2.jdbcx.JdbcConnectionPool;
public class Test {
    public static void main(String[] args) throws Exception {
       
        System.out.println("Done");
        show();
    }
    
    public static void  show()
    {
    	 JdbcConnectionPool cp = JdbcConnectionPool.create(
    	            "jdbc:h2:~/test", "sa", "sa");
    	        /*for (int i = 0; i < args.length; i++) {
    	            Connection conn = cp.getConnection();
    	            conn.createStatement().execute(args[i]);
    	            conn.close();
    	        }
    	        cp.dispose();
    	        */
    	        System.out.println("# DUMP " + cp);
    	        String sql = "select ID, NAME, SALARY from CUSTOMER";
    	        try  {
    	        	
    	        	Connection connection = cp.getConnection();
    	            System.out.println("# DUMP " + sql);
    	            System.out.println("start");
    	    
    	            	Statement stmt = connection.createStatement();
    	            	
    	          
    	                	ResultSet rst = stmt.executeQuery(sql);	
    	                	while(rst.next())
    	                	{
    	                	
    	                		System.out.println("Done"+rst.getString("NAME"));
    	                	}
    	                
    	            //}
    	            System.out.println("----");
    	        } catch (SQLException e) {
    	        	e.printStackTrace();
    	           // throw new RuntimeSqlException(e);
    	        }
    	        

    	        
    	      //  dump(sql,cp);
    }
    public static void dump(String sql, JdbcConnectionPool jdbcConnectionPool) //throws RuntimeSqlException 
    {
        try (Connection connection = jdbcConnectionPool.getConnection()) {
            System.out.println("# DUMP " + sql);
            System.out.println();
            try (Statement stmt = connection.createStatement()) {
                try (ResultSet rst = stmt.executeQuery(sql)) {
                	
                	while(rst.next())
                	{
                	
                		System.out.println("Done"+rst.getString("NAME"));
                	}
                }
            }
            System.out.println("----");
        } catch (SQLException e) {
           // throw new RuntimeSqlException(e);
        }
    }
     
}