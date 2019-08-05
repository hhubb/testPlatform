package com.icode.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.minidev.json.JSONUtil;
import org.json.JSONString;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    private static boolean stop = false;
    private static boolean flag = false;
    private static  int sum = 0;

    public static void main(String[] args) throws InterruptedException{

//        sum=9;
//        sum=sum+1;
//        System.out.print(sum.getClass());
        String name="prometheus:服务名:方法名:主机名:端口, 事件内容+其它字段";
        String[] originInfo=name.split(":");
        if(originInfo!=null){
            String originServiceName=originInfo[1];
            String originMethodName=originInfo[2];
            String originHostNameName=originInfo[3];
            String originPort=originInfo[4];
            System.out.println("originServiceName:"+originServiceName
                    +"originMethodName:"+originMethodName
                    +"originHostNameName:"+originHostNameName+
                    "originPort:"+originPort);
            long a=123;
            long b=7;
            DecimalFormat df = new DecimalFormat("0.0000");//格式化小数
            float c=(float)a/b;
            String s = df.format(c);//返回的是String类型


            System.out.println(s);
        }


    }
    @Test
    public void contextLoads() {
        List<Map<String,Object>> originalList=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("ip","123");
        map.put("name","cpu大于80");
        map.put("ory_type","1");
        map.put("time","1");
        originalList.add(map);
        Map<String,Object> map2=new HashMap<>();
        map2.put("ip","123");
        map2.put("name","cpu大于80");
        map2.put("ory_type","1");
        map2.put("time","2");
        originalList.add(map2);
        Map<String,Object> map3=new HashMap<>();
        map3.put("ip","123");
        map3.put("name","cpu大于80");
        map3.put("ory_type","2");
        map3.put("time","3");
        originalList.add(map3);
        Map<String,Object> map4=new HashMap<>();
        map4.put("ip","222");
        map4.put("name","cpu大于80");
        map4.put("ory_type","1");
        map4.put("time","4");
        originalList.add(map4);
        Map<String,Object> map5=new HashMap<>();
        map5.put("ip","222");
        map5.put("name","cpu大于80");
        map5.put("ory_type","2");
        map5.put("time","5");
        originalList.add(map5);
        Map<String,Object> map6=new HashMap<>();
        map6.put("ip","222");
        map6.put("name","cpu大于90");
        map6.put("ory_type","1");
        map6.put("time","6");
        originalList.add(map6);
        Map<String,Object> map7=new HashMap<>();
        map7.put("ip","222");
        map7.put("name","cpu大于90");
        map7.put("ory_type","2");
        map7.put("time","7");
        originalList.add(map7);
        Map<String,Object> map8=new HashMap<>();
        map8.put("ip","222");
        map8.put("name","cpu大于90");
        map8.put("ory_type","1");
        map8.put("time","8");
        originalList.add(map8);
        Map<String,Object> map9=new HashMap<>();
        map9.put("ip","222");
        map9.put("name","cpu大于90");
        map9.put("ory_type","2");
        map9.put("time","9");
        originalList.add(map9);
        Map<String,Object> map10=new HashMap<>();
        map10.put("ip","265");
        map10.put("name","999999");
        map10.put("ory_type","1");
        map10.put("time","10");
        originalList.add(map10);
        Map<String,Object> map11=new HashMap<>();
        map11.put("ip","7777");
        map11.put("name","sdfsdf");
        map11.put("ory_type","1");
        map11.put("time","11");
        originalList.add(map11);
        Map<String,Object> map12=new HashMap<>();
        map12.put("ip","888");
        map12.put("name","sdfsdf");
        map12.put("ory_type","1");
        map12.put("time","12");
        originalList.add(map12);
        Map<String,Object> map13=new HashMap<>();
        map13.put("ip","888");
        map13.put("name","sdfsdf");
        map13.put("ory_type","1");
        map13.put("time","13");
        originalList.add(map13);

        //实现
        Map<String,Object> eventMap=new HashMap<>();
        List<Map<String,Object> > alarmedList=new ArrayList<>();//已恢复list
        for( Map<String,Object> data:originalList){
            String eventString=data.get("ip").toString()+data.get("name");
            if(!eventMap.containsKey(eventString)){
                data.put("eventCount",1);
                List<Map<String,Object>> subEventList=new ArrayList<>();
                subEventList.add(data);
                data.put("subEventList",JSONObject.toJSON(data).toString());
               // data.put("subEventList",subEventList);
                eventMap.put(eventString,data);
            }else{
                Map<String,Object> eventData= (Map<String,Object>)eventMap.get(eventString);
                int eventCount=Integer.parseInt(eventData.get("eventCount").toString())+1;
//                List<Map<String,Object>> subEventList=(List<Map<String,Object>> ) eventData.get("subEventList");
//                subEventList.add(data);
                String subEventList=JSONObject.toJSON(eventData.get("subEventList").toString()+","+JSONObject.toJSON(data).toString()).toString();

                data.put("eventCount",eventCount);
                data.put("subEventList",subEventList);
                eventMap.put(eventString,data);

            }
            if(data.get("ory_type").toString().equals("2")){
               String subEventList="["+data.get("subEventList").toString()+"]" ;
                data.put("subEventList",subEventList) ;
                alarmedList.add(data);
                eventMap.remove(eventString);
            }


        }
        //已完成eventMapList

        for(Map<String,Object> alarmed: alarmedList) {
            System.out.println("以恢复数量"+alarmedList.size()+",当前事件数量："+alarmed.get("eventCount"));
            System.out.println(JSONObject.toJSON(alarmed));
        }

        //告警中数量
        Collection<Object> valueCollection = eventMap.values();
        final int size = valueCollection.size();

        List<Object> valueList = new ArrayList<Object>(valueCollection);
        for(Object alarming: valueList) {
            Map<String,Object>  alarmingMap=(Map<String,Object>)alarming;
            System.out.println("告警中数量"+valueList.size()+",当前事件数量："+alarmingMap.get("eventCount"));
        }




    }
    @Test
    public void test(){
        String a="Cv 79 agctu qh cig";
       String sb="";
        char[] array=a.toCharArray();
        for(char i:array){
            if(i+""==null  ){
                sb+=Integer.toString(i);
            }else
            if((i>=65 && i<=90)){
                if(i+2>90){
                    sb+=Integer.toString(65+(90-(i+2)));
                }else{
                    sb+=Integer.toString(i+2);
                }

            }else
            if(i>=97 && i<=122){
                if(i+2>122){
                    sb+=Integer.toString((65+(90-(i+2))));
                }else{
                    sb+=Integer.toString(i+2);
                }
            }else{
                sb+=Integer.toString(9-i);
            }
        }
        System.out.println(sb);

        int r=69;
        String s=Integer.toString(r);
        System.out.println(s);
    }

}
