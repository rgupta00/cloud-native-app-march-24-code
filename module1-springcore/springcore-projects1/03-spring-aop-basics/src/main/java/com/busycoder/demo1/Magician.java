package com.busycoder.demo1;

import org.springframework.stereotype.Component;

//When magician is showing the magic after that Audience should clap
//design pattern: proxy dp
@Component(value = "m")
public class Magician {

    public String doMagic(){
//        if(1==1)
//            throw  new FeverEx("call the dr now");
        System.out.println("abara ka dabra");
        return "rabbit out of the hat";
    }
}
