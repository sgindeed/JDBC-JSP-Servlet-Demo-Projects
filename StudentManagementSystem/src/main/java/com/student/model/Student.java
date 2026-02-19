package com.student.model;

public class Student {
    private int id;
    private String name;
    private String address;
    private String branch;

    public Student(int id, String name, String address, String branch) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.branch = branch;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getBranch() { return branch; }
}