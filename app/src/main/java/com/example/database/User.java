package com.example.database;

public class User {

    private String Name;
    private int Age;
    private double Height;
    private double Weight;
    private String ID;

    public User(String name, int age, double height, double weight, String id) {
        Name = name;
        Age = age;
        Height = height;
        Weight = weight;
        ID = id;
    }

    public User() { };

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "User{" +  "Name='" + Name + '\'' +
                ", Age='" + Age + '\'' +
                ", Height=" + Height +
                ", Weight='" + Weight + '\'' +
                '}';
    }
}
