package com.icode.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BbsApplicationTests {

    private static Integer sum=0;
    private static boolean stop =false;
//    @Test
//    public void contextLoads() {
//        new Thread(()->{
//            while(!stop){
//                //sum++;
//                sum = 9;
//            }
//            System.out.println("sum = "+sum);
//        }).start();
//        Thread.sleep(400);
//        stop = true;
//    }

    public static void main(String[] args) throws InterruptedException{

        new Thread(()->{
            while(!stop){
                //sum++;
                sum = 9;
            }
            System.out.println("sum = "+sum);
        }).start();
        Thread.sleep(400);
        stop = true;
    }



}
