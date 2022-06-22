package com.idansalman.chessprogram.Classes;

public class User {
    protected String id;
    private String fName;
    private String lName;
    private String Phone;
    private String Email;
    private String Password;

    public User(String id, String fName, String lName, String phone, String email, String password) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        Phone = phone;
        Email = email;
        Password = password;
    }

    public User(String id, String fName, String lName, String phone, String email) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        Phone = phone;
        Email = email;
    }

    public User() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
