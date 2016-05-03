package com.example.employeezy.adiprojecttwo;

/**
 * Created by EmployYeezy on 5/2/16.
 */
public class Player {

    int id;
    String name, year;

    public Player (int id, String name, String year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                '}';


    }
}
