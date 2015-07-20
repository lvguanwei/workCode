package com.alibaba.cobar.manager.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class MonitorMain {

    public static void main(String[] args) throws Exception {
//        String url = "jdbc:mysql://localhost:9066";
//        Properties info = new Properties();
//        info.setProperty("user", "test");
//        info.setProperty("password", "test");
//        Connection con = null;
        
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("test");
        ds.setPassword("test");
        ds.setUrl("jdbc:mysql://127.0.0.1:9066/");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setMaxActive(-1);
        ds.setMinIdle(0);
        ds.setTimeBetweenEvictionRunsMillis(600000);
        ds.setNumTestsPerEvictionRun(Integer.MAX_VALUE);
        ds.setMinEvictableIdleTimeMillis(GenericObjectPool.DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS);
        Connection con = ds.getConnection();
        
        try {
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
//            for(;;){
//                
//                Statement stmt = con.createStatement();
//                String query ="show @@processor";
//                stmt.execute(query);
//                ResultSet rs = stmt.getResultSet();
//                StringBuilder sb = new StringBuilder();
//                for(int i=1;i<11;i++){
//                    sb.append("|   ")
//                      .append(rs.getString(i))
//                      .append("                 ".substring(0,14-rs.getString(i).length()));
//                }
//                sb.append("|");                
//                System.out.println(sb.toString());
//                rs.close();
//                stmt.close();
//                Thread.sleep(1000);
//            }
            Statement stm = con.createStatement();
            stm.execute("show @@version");
            
            ResultSet rst = stm.getResultSet();
            rst.next();
            String version = rst.getString("VERSION");
            
            System.out.println(version);
            
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        
    }

}
