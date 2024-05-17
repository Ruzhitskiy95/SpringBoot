package com.example.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

//        String alex = new BCryptPasswordEncoder().encode("Alex");
//        System.out.println("alex = " + alex);
//        String nick = new BCryptPasswordEncoder().encode("Nick");
//        System.out.println("nick = " + nick);
//        String tom = new BCryptPasswordEncoder().encode("Tom");
//        System.out.println("tom = " + tom);
//        String rikki = new BCryptPasswordEncoder().encode("Rikki");
//        System.out.println("rikki = " + rikki);
    }
}
