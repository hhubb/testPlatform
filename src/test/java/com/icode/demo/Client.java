package com.icode.demo;

import com.icode.testplatform.entity.User;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket=new Socket("localhost",8080);

//            Scanner scanner=new Scanner(System.in);
//            while(scanner.hasNext()){
//                out.print(scanner.nextLine());
//            }
            User user=new User();
            user.setUsername("hbb");
            user.setAge(18);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(new File("user")));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
            socket.close();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
