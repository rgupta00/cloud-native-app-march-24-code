package com.busycoder.demo0;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Main {

    private static Logger logger=LoggerFactory.getLogger(Main.class);
  //  private static Logger logger= LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("code is working till line no 10");
        //System.out.println("code is working till line no 6");

        try{
            String data="123a";
            int val=Integer.parseInt(data);
        }catch (Exception e){
            logger.error("ex occured {} ",e.getMessage());
        }

      //  System.out.println("code is working till line no 12");


        //this sysout i forget to comment and then it is comming in consle of prod server

       /// System.out.println("code is working till line no 17");

    }
}