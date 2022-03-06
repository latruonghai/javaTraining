package com.lth.demoApp.models;

import java.util.UUID;

public class Person {
    private final UUID id;
    private final String name;

    public Person(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

}
