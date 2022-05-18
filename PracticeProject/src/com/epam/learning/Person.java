package com.epam.learning;

import java.util.ArrayList;
import java.util.List;

public class Person {


    public void printPerson() {
        System.out.println(this.toString());
    }

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    int age;
    Sex gender;
    String emailAddress;

    public String getName() {
        return name;
    }

    public Integer getNameLength() {
        return name.length();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Person() {
    }

    public Person(String name, int age, Sex gender, String emailAddress) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }



    public static List<Person> generateDefaultList() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Shabbired", 20, Sex.MALE, "shabbir@gmail.com"));
        people.add(new Person("Nikhilqqqqqq", 21, Sex.MALE, "nikhil@gmail.com"));
        people.add(new Person("Shiv", 19, Sex.MALE, "shivam@gmail.com"));
        return  people;
    }
}