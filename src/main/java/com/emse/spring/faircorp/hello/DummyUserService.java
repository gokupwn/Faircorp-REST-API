package com.emse.spring.faircorp.hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyUserService implements UserService{

    private final GreetingService GS;

    @Autowired
    public DummyUserService (GreetingService GS){
        this.GS = GS;
    }
    public void greetAll(){
        String [] Usernames = {"Elodie", "Charles"};
        for (String name: Usernames) {
            GS.greet(name);
        }
    }
}
