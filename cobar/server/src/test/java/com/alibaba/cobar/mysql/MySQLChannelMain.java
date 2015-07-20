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
package com.alibaba.cobar.mysql;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

import com.alibaba.cobar.config.Capabilities;
import com.alibaba.cobar.config.model.DataSourceConfig;
import com.alibaba.cobar.mysql.bio.Channel;
import com.alibaba.cobar.net.mysql.AuthPacket;
import com.alibaba.cobar.net.mysql.BinaryPacket;
import com.alibaba.cobar.net.mysql.CommandPacket;
import com.alibaba.cobar.net.mysql.HandshakePacket;
import com.alibaba.cobar.net.mysql.MySQLPacket;
import com.alibaba.cobar.util.TimeUtil;

/**
 * @author xianmao.hexm 2011-5-6 下午08:59:07
 */
public class MySQLChannelMain {

    public Channel getChannel() throws Exception {
        DataSourceConfig config = new DataSourceConfig();
        config.setHost("127.0.0.1");
        config.setPort(3306);
        config.setUser("root");
        config.setPassword("Spring33");
        config.setDatabase("dbtest1");
        MySQLDataSource ds = new MySQLDataSource(null, 0, config, 1);
        return ds.getChannel();
    }
    
    /**
     * 发送411协议的认证数据包
     */
//    private BinaryPacket sendAuth411(HandshakePacket hsp) throws IOException, NoSuchAlgorithmException {
//        
//        return receive();
//    }
    
    
    /**
     * 与MySQL连接时的一些特性指定
     */
    private static long getClientFlags() {
        int flag = 0;
        flag |= Capabilities.CLIENT_LONG_PASSWORD;
        flag |= Capabilities.CLIENT_FOUND_ROWS;
        flag |= Capabilities.CLIENT_LONG_FLAG;
        flag |= Capabilities.CLIENT_CONNECT_WITH_DB;
        // flag |= Capabilities.CLIENT_NO_SCHEMA;
        // flag |= Capabilities.CLIENT_COMPRESS;
        flag |= Capabilities.CLIENT_ODBC;
        // flag |= Capabilities.CLIENT_LOCAL_FILES;
        flag |= Capabilities.CLIENT_IGNORE_SPACE;
        flag |= Capabilities.CLIENT_PROTOCOL_41;
        flag |= Capabilities.CLIENT_INTERACTIVE;
        // flag |= Capabilities.CLIENT_SSL;
        flag |= Capabilities.CLIENT_IGNORE_SIGPIPE;
        flag |= Capabilities.CLIENT_TRANSACTIONS;
        // flag |= Capabilities.CLIENT_RESERVED;
        flag |= Capabilities.CLIENT_SECURE_CONNECTION;
        // client extension
        // flag |= Capabilities.CLIENT_MULTI_STATEMENTS;
        // flag |= Capabilities.CLIENT_MULTI_RESULTS;
        return flag;
    }
    
    public static BinaryPacket receive(InputStream in) throws IOException {
        BinaryPacket bin = new BinaryPacket();
        bin.read(in);
        return bin;
    }
    

    public static void main(String[] args)  {
       try{
           
      
//        MySQLChannelMain test = new MySQLChannelMain();
//        Channel channel = test.getChannel();
//        channel.close();

     // 网络IO参数设置
        Socket socket = new Socket();
        socket.setTcpNoDelay(true);
        socket.setTrafficClass(0x04 | 0x10);
        socket.setPerformancePreferences(0, 2, 1);
        socket.setReceiveBufferSize(16384);
        socket.setSendBufferSize(8192);
        socket.connect(new InetSocketAddress("127.0.0.1", 3306), 10000);

        // 直接通过socket进行通信
        InputStream in = new BufferedInputStream(socket.getInputStream(), 16384);
        OutputStream out = new BufferedOutputStream(socket.getOutputStream(), 8192);
        
     // 读取握手数据包
        BinaryPacket initPacket = new BinaryPacket();
        initPacket.read(in);
        HandshakePacket hsp = new HandshakePacket();
        hsp.read(initPacket);
     // 发送认证数据包
        BinaryPacket bin = null;
        try {
            AuthPacket ap = new AuthPacket();
            ap.packetId = 1;
            ap.clientFlags = getClientFlags();
            ap.maxPacketSize = 1024 * 1024 * 16;
            ap.charsetIndex = 33;
            ap.user = "root";
            String passwd = "Spring33";
            if (passwd != null && passwd.length() > 0) {
                byte[] password = passwd.getBytes("utf8");
                byte[] seed = hsp.seed;
                byte[] restOfScramble = hsp.restOfScrambleBuff;
                byte[] authSeed = new byte[seed.length + restOfScramble.length];
                System.arraycopy(seed, 0, authSeed, 0, seed.length);
                System.arraycopy(restOfScramble, 0, authSeed, seed.length, restOfScramble.length);
                ap.password = SecurityUtil.scramble411(password, authSeed);
            }
            ap.database = "dbtest1";
            ap.write(out);
            out.flush();
            bin = receive(in);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        
      //执行SQL
        for(int i = 0;i<4;i++){
         // 生成执行数据包
            Thread.sleep(10000);
            CommandPacket packet = new CommandPacket();
            packet.packetId = 0;
            packet.command = MySQLPacket.COM_QUERY;


            packet.arg = "select 1".getBytes("utf8");

            

            // 递交执行数据包并等待执行返回
            packet.write(out);
            out.flush();
            bin = receive(in);
            System.out.println(bin.packetLength+" "+bin.toString());
            System.out.println(i);
        }
        Thread.sleep(31000);
        CommandPacket packet = new CommandPacket();
        packet.packetId = 0;
        packet.command = MySQLPacket.COM_QUERY;


        packet.arg = "select 1".getBytes("utf8");

        

        // 递交执行数据包并等待执行返回
        packet.write(out);
        out.flush();
        bin = receive(in);
        System.out.println(bin.packetLength+" "+bin.toString());
        System.out.println("new ok");
        
       }catch(Exception e){
           e.printStackTrace();
       }
        
    }

}
