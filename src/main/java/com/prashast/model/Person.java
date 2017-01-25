package com.prashast.model;


public class Person {

    private String firstName;
    private String lastName;
    private String dob;
    private String mobNumber;
    private String extn;
    private String emailAddr;
    private String gender;

    public Person(String firstName, String lastName, String dob, String mobNumber, String extn, String emailAddr, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.mobNumber = mobNumber;
        this.extn = extn;
        this.emailAddr = emailAddr;
        this.gender = gender;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    public String getExtn() {
        return extn;
    }

    public void setExtn(String extn) {
        this.extn = extn;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
