package com.busycoder.demo3;

public class CityApi {

    public String getCity(int l){
        try{
            Thread.sleep(1400);
        }catch (InterruptedException e){}

        return "Delhi";
    }
}
