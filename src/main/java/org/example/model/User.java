package org.example.model;

public class User {
    private int uid;
    private String password;
    private String email;

    public User() {
    }

    public User(int uid, String password, String email) {
        this.uid = uid;
        this.password = password;
        this.email = email;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
