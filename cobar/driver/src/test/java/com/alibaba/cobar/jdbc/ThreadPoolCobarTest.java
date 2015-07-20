package com.alibaba.cobar.jdbc;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolCobarTest {
    
    public static class CobarExecTask implements Runnable, Serializable {
        private static final long serialVersionUID = 0;
        // 保存任务所需要的数据
        private String sql;
 
        CobarExecTask(String sql) {
            this.sql = sql;
        }
 
        public void run() {
            // 处理一个任务，这里的处理方式太简单了，仅仅是一个打印语句
            //System.out.println("sql =" + this.sql);
            try {
                Class.forName("com.alibaba.cobar.jdbc.Driver");
                String url = "jdbc:mysql://172.7.4.60:8066/dbtest";
                Properties info = new Properties();
                info.setProperty("user", "test");
                info.setProperty("password", "test");
                Connection con = null;
                con = DriverManager.getConnection(url, info);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(this.sql);
                rs.close();
                stmt.close();
                con.close();
               
            } catch (Exception e) {
 
                e.printStackTrace();
            }
        }
 
    }
    
    
    public static void main(String[] args) {
        
        // 构造一个线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(500, 500, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000),
                new ThreadPoolExecutor.DiscardOldestPolicy());
 
            try {
                // 产生一个任务，并将其加入到线程池
                String sql = "select sleep(5) ";
                for(int i=0;i<64;i++){
                    threadPool.execute(new CobarExecTask(sql));
                }
//                sql="select * from alarm_log where user_id = '3ea6483a00db4f78af762cabc24c1d52_test' ";
//                threadPool.execute(new CobarExecTask(sql));
                //超过数据库的wait_timeout
                Thread.sleep(26000);
                for(int i=0;i<64;i++){
                    threadPool.execute(new CobarExecTask(sql));
                }
//                threadPool.execute(new CobarExecTask(sql));
                int cc= 0;
                for(;;){
                    int size = threadPool.getQueue().size();
                    System.out.println("size="+size);
                    cc++;
                    if(size == 0 && cc>600){
                        return;
                    }
                    Thread.sleep(1000);
                    
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }

}
