package com.imit.task.eighth.differentClasses;

public class Student extends Human{
    private String nameGroup;

    public Student(String firstname, String surname, String lastName, String nameGroup) {
        super(firstname, surname, lastName);
        this.nameGroup = nameGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }
}
