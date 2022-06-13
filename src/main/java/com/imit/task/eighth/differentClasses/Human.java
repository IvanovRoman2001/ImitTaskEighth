package com.imit.task.eighth.differentClasses;

import com.imit.task.eighth.Executable;

public class Human implements Executable {
    private String firstName;
    private String surname;
    private String lastName;

    public Human(String firstName, String surname, String lastName) {
        this.firstName = firstName;
        this.surname = surname;
        this.lastName = lastName;
    }

    private void test(){}
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void execute() {
        System.out.println("Hello World");
    }
}
