package com.amber;

public class Greeting {
    private String firstName;
    private String lastName;

    public Greeting(String firstName, String lastName) throws IllegalAccessException {
        setName(firstName, lastName);
    }

    //SET
    private void setName(String firstName, String lastName )  throws IllegalAccessException{
        if(firstName == "" || firstName == null) throw new IllegalAccessException("Please enter name");
        if(lastName == "" || lastName == null) throw new IllegalAccessException("Please enter name");
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //GET
    private String getName() {
        return firstName + " " + lastName;
    }

    // PUBLIC GREETING


    public String greetUser() {
        return "Hello " + firstName + " " + lastName;
    }
}


