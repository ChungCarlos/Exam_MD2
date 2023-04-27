package model;

import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double GPA;

    public Student(String id, String name, int age, String gender, String address, double GPA) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.GPA = GPA;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student..." +
                " Id: " + id +
                " Name: " + name +
                " Age: " + age +
                " Gender: " + gender + '\'' +
                " Address:" + address +
                " GPA:" + GPA
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Double.compare(student.GPA, GPA) == 0 && id.equals(student.id) && name.equals(student.name) && gender.equals(student.gender) && address.equals(student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, gender, address, GPA);
    }
}
