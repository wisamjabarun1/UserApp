package com.example.UserApp.Models;

import java.util.Date;

public class User {

    private int Id;
    private String Name;
    private String LastName;
    private String Email;
    private int Age ;
    private  String Address;
    private Date JoiningDate;



    public User() {
    }

    public User(String address, int age, String email, int id, Date joiningDate, String lastName, String name) {
        Address = address;
        Age = age;
        Email = email;
        Id = id;
        JoiningDate = joiningDate;
        LastName = lastName;
        Name = name;
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getJoiningDate() {
        return JoiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        JoiningDate = joiningDate;
    }





    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "Address='" + Address + '\'' +
                ", Id=" + Id +
                ", Name='" + Name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Age=" + Age +
                ", JoiningDate=" + JoiningDate +
                '}';
    }
}

