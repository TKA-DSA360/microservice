package com.jbk.clients;

import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {

    @Override
    public Boolean isUserExists(long userId) {
        System.out.println("User Service is DOWN — fallback executed");
        return false;
    }
}
