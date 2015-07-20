/*
 * Copyright 1999-2012 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.cobar.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author xianmao.hexm 2012-4-27
 */
public class DriverMain {

    public static void main(String[] args) throws Exception {
//        Class.forName("com.alibaba.cobar.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://172.7.4.60:3306/test?characterEncoding=utf-8&useUnicode=true&autoReconnect=true&autoReconnectForPools=true&zeroDateTimeBehavior=convertToNull";
        Properties info = new Properties();
        info.setProperty("user", "testuser");
        info.setProperty("password", "testuser");
        Connection con = null;
        con = DriverManager.getConnection(url, info);
        Statement stmt = con.createStatement();
        String query ="select sleep(20) ";
        ResultSet rs = stmt.executeQuery(query);
//        rs.close();
//        stmt.close();
//        con.close();
//        
//        con = DriverManager.getConnection(url, info);
        stmt = con.createStatement();
        query ="select sleep(20) ";
        rs = stmt.executeQuery(query);
        rs.close();
        stmt.close();
        con.close();
        
        
        con = DriverManager.getConnection(url, info);
        stmt = con.createStatement();
        query ="select * from alarm_log where user_id = '3ea6483a00db4f78af762cabc24c1d52_test' ";//union select * from alarm_log_new where user_id = '3ea6483a00db4f78af762cabc24c1d52_test'";
        rs = stmt.executeQuery(query);
        rs.close();
        stmt.close();
        con.close();
        
//       
//        long bb = System.nanoTime();
//        int cc = 0;
//        
//            long beginTime = System.currentTimeMillis();
//            try {
//            con = DriverManager.getConnection(url, info);
//                
////                    for(;;){
//                        con = DriverManager.getConnection(url, info);
////                        try {
////                        long endTime = System.currentTimeMillis();
////                        if(endTime - beginTime >60000){
////                            break;
////                        }
//                Statement stmt = con.createStatement();
////                String query = "INSERT INTO alarm_log (id,user_id,device_serial,channel_type,channel_no,object_name,sys_code,start_time, is_video,is_check,log_info,picurl,recurl,s_picurl,s_recurl,create_time,dev_alarm_start_time,dev_alarm_stop_time,rec_state,relation_id,pic_url_group,sample_name)  VALUES ('622674c2-f9b6-45c9-975b-3ba0968454a0','3ea6483a00db4f78af762cabc24c1d52_test','11',1,1,'11',1,'2015-06-15 09:57:43',1,0,'日志详细信息','null','null','null','null','2015-06-03 09:56:36','2015-06-15 09:57:43','2015-06-15 09:57:43',0,'default','null','null'),('9969cf82-1498-450f-9fbf-064cb0515d31','3ea6483a00db4f78af762cabc24c1d52_test','11',1,1,'11',1,'2015-06-15 09:57:44',1,0,'日志详细信息','null','null','null','null','2015-06-03 09:56:36','2015-06-15 09:57:44','2015-06-15 09:57:44',0,'default','null','null'),('6fb13665-aa1e-4e59-b16a-0e3b1a03a788','3ea6483a00db4f78af762cabc24c1d52_test','11',1,1,'11',1,'2015-06-15 09:57:44',1,0,'日志详细信息','null','null','null','null','2015-06-03 09:56:36','2015-06-15 09:57:44','2015-06-15 09:57:44',0,'default','null','null'),('216c260d-e5d7-48dd-b1b9-2fd87576b75d','3ea6483a00db4f78af762cabc24c1d52_test','11',1,1,'11',1,'2015-06-15 09:57:44',1,0,'日志详细信息','null','null','null','null','2015-06-03 09:56:36','2015-06-15 09:57:44','2015-06-15 09:57:44',0,'default','null','null'),('3569a8f8-bdbc-4148-8f5c-a21aea6d8a88','3e033e431e2e4ceb8e90e8aad8b2b2a4_test','11',1,1,'11',1,'2015-06-15 09:57:44',1,0,'日志详细信息','null','null','null','null','2015-06-03 09:56:36','2015-06-15 09:57:44','2015-06-15 09:57:44',0,'default','null','null'),('2a1c3dca-488e-46ef-90da-0dc42d285318','3e033e431e2e4ceb8e90e8aad8b2b2a4_test','11',1,1,'11',1,'2015-06-15 09:57:44',1,0,'日志详细信息','null','null','null','null','2015-06-03 09:56:36','2015-06-15 09:57:44','2015-06-15 09:57:44',0,'default','null','null'),('b3005ddc-d51f-4298-ac05-e513a24fb9e3','3ea6483a00db4f78af762cabc24c1d52_test','11',1,1,'11',1,'2015-06-15 09:57:44',1,0,'日志详细信息','null','null','null','null','2015-06-03 09:56:36','2015-06-15 09:57:44','2015-06-15 09:57:44',0,'default','null','null'),('c8de90ea-ce4f-4e70-a507-8b04c4c94765','3ea6483a00db4f78af762cabc24c1d52_test','11',1,1,'11',1,'2015-06-15 09:57:44',1,0,'日志详细信息','null','null','null','null','2015-06-03 09:56:36','2015-06-15 09:57:44','2015-06-15 09:57:44',0,'default','null','null')";
 //               String query ="select * from alarm_log where user_id = '3ea6483a00db4f78af762cabc24c1d52_test' ";//union select * from alarm_log_new where user_id = '3ea6483a00db4f78af762cabc24c1d52_test'";
//                ResultSet rs = stmt.executeQuery(query);
                int rowcount = 0;
//                while (rs.next()) {
//                   System.out.println("id:" + rs.getString(1) + ",new_id:"+rs.getString(1) +",create_date:" + rs.getString(8));
//                    ++rowcount;
//                    
//                }
//                if(rowcount == 0){
//                    System.out.println(" return value error");
//                }
//                //System.out.println("cc=="+cc);
                
//                Thread.sleep(15000);
//                rs = stmt.executeQuery(query);
                
                
                rs.close();
////                boolean success = stmt.execute(query);
////                 System.out.println("success =="+success);
                stmt.close();
//                ++cc;
                
//                        } finally {
//                            if (con != null) {
//                                con.close();
//                            }
//                        }
//        
//       // System.out.println("cc="+cc+" time="+(System.nanoTime()-bb));
        System.out.println(System.currentTimeMillis());
    }

}
