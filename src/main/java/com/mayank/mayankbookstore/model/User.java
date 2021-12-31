package com.mayank.mayankbookstore.model;

public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private int phone;
    private int userType;
    private String emailId;

    public static String TABLE_USERS = "users";

    public static String COLUMN_USERNAME = "username";
    public static String COLUMN_PASSWORD = "password";
    public static String COLUMN_FIRSTNAME = "firstname";
    public static String COLUMN_LASTNAME = "lastname";
    public static String COLUMN_ADDRESS = "address";
    public static String COLUMN_PHONE = "phone";
    public static String COLUMN_MAILID = "mailid";
    public static String COLUMN_USERTYPE = "usertype";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", userType=" + userType +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
