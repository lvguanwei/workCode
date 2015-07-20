package com.alibaba.cobar.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MonitorMain {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://172.7.4.60:9066";
        Properties info = new Properties();
        info.setProperty("user", "test");
        info.setProperty("password", "test");
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, info);
            System.out.println("|   NAME             "+
                    "|   POOL_SIZE        "+
                    "|   ACTIVE_COUNT     "+
                    "|   TASK_QUEUE_SIZE  "+
                    "|   COMPLETED_TASK   "+
                    "|   TOTAL_TASK       ");
            for(;;){
                showThreadPool(con,true);
                Thread.sleep(1000);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        
    }
    
    
    public static void showProcess(Connection con,boolean showHeader){
        try{
            if(showHeader){
                System.out.println("|   NAME          "+
                        "|   NET_IN        "+
                        "|   NET_OUT       "+
                        "|   REACT_COUNT   "+
                        "|   R_QUEUE       "+
                        "|   W_QUEUE       "+
                        "|   FREE_BUFFER   "+
                        "|   TOTAL_BUFFER  "+
                        "|   FC_COUNT      "+
                        "|   BC_COUNT      |");
            }
            Statement stmt = con.createStatement();
            String query ="show @@processor";
            stmt.execute(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                StringBuilder sb = new StringBuilder();
                for(int i=1;i<11;i++){
                    sb.append("|   ")
                      .append(rs.getString(i))
                      .append("                 ".substring(0,14-rs.getString(i).length()));
                }
                sb.append("|"); 
                System.out.println(sb.toString());
                
             }
           
            rs.close();
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void showThreadPool(Connection con,boolean showHeader){
        try{
            if(showHeader){
                System.out.println("|   NAME             "+
                        "|   POOL_SIZE        "+
                        "|   ACTIVE_COUNT     "+
                        "|   TASK_QUEUE_SIZE  "+
                        "|   COMPLETED_TASK   "+
                        "|   TOTAL_TASK       ");
            }
            Statement stmt = con.createStatement();
            String query ="show @@threadpool";
            stmt.execute(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                StringBuilder sb = new StringBuilder();
                for(int i=1;i<7;i++){
                    sb.append("|   ")
                      .append(rs.getString(i))
                      .append("                 ".substring(0,17-rs.getString(i).length()));
                }
                sb.append("|");                
//                if (rs.getInt(4) >0){
                    System.out.println(sb.toString());
               // }
             }
           
            rs.close();
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

}
