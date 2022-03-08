package com.lth.demoBeans;

public class Office {
    private Developer developer;
    private Tester tester;


    public Office(Developer developer, Tester tester) {
        this.developer = developer;
        this.tester = tester;
    }
//    public void setDeveloper(Developer developer) {
//        this.developer = developer;
//    }
//
//    public void setTester(Tester tester) {
//        this.tester = tester;
//    }



    public Developer getDeveloper() {
        return developer;
    }

    public Tester getTester() {
        return tester;
    }
}
