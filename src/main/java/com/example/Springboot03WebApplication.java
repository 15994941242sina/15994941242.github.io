package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot03WebApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(Springboot03WebApplication.class, args);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
