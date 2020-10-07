package com.example.studyplanner;

public class User {

    public static User instance;
    private String roll;
    private String sem;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public String getroll() {
        return roll;
    }
    public void setroll(String roll) {
        this.roll = roll;
    }
    public String getsem() {
        return sem;
    }

    public void setsem(String sem) {
        this.sem = sem;
    }
}
