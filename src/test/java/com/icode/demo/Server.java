package com.icode.demo;


import org.apache.log4j.net.SocketServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket socketServer;
        Socket socket;
        BufferedReader br;
        boolean flag=true;
        try{
             socketServer=new ServerSocket(8080);
             socket=socketServer.accept();
             br=new BufferedReader(new InputStreamReader(socket.getInputStream()));


//            //while (!"q".equals(br.readLine())){
//            while(flag){
//                String read=br.readLine();
//                System.out.println(read);
//                if("q".equals(read.toLowerCase())){
//                    flag=false;
//                    System.out.println("回话结束");
//                }
//            }

            ObjectInputStream objectInputStream=new ObjectInputStream(new BufferedInputStream(new FileInputStream("user")));

            System.out.println(objectInputStream.readObject());
            br.close();
            socket.close();
            socketServer.close();



        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        }



}
