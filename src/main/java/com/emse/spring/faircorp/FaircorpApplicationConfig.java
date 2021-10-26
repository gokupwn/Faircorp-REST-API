//package com.emse.spring.faircorp;
//
//import com.emse.spring.faircorp.hello.GreetingService;
//import com.emse.spring.faircorp.hello.UserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//// (1)
//@Configuration
//public class FaircorpApplicationConfig {
//
//    // (2)
//    @Bean
//    public CommandLineRunner greetingCommandLine(GreetingService GS) { // (3)
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                // (4)
//                GS.greet("Spring");
//            }
//        };
//    }
//}