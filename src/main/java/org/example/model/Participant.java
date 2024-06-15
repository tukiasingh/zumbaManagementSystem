package org.example.model;

public class Participant {

    private int pid;
    private String name;
    private String phone;
    private String email;

    public Participant() {
    }

    public Participant(int pid, String name, String phoneNumber, String email) {
        this.pid = pid;
        this.name = name;
        this.phone = phoneNumber;
        this.email = email;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
