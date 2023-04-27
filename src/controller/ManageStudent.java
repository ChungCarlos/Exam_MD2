package controller;

import model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManageStudent {
    private ArrayList<Student> listStudent;


    public ManageStudent() {
        listStudent = new ArrayList<>();
//        write = new WriteFile<>();
//        read = new ReadFile<>();
//        listStudent = read.readFile();
    }

    public ManageStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    // 1. Display list
    public void displayList() {
        System.out.println("List has: " + listStudent.size() + " Candidate.");
        for (Student candidates : listStudent) {
            System.out.println(candidates);
        }
        if (listStudent.isEmpty()) {
            System.out.println("Empty list...");
        }
    }

    // 2.Add
    public void add(Student student) {
        listStudent.add(student);
    }

    // 3.Update
    public void update(String id) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        for (Student student : listStudent) {
            if (student.getId().toLowerCase().indexOf(id.toLowerCase()) >= 0) {
                check = true;
                System.out.println("Candidate search list: \n" + student);
                System.out.println("""
                         |>-----------------------<|
                         |    What do you          |
                         |         want to edit?   |
                         |>-----------------------<|
                         |  1. ID                  |
                         |  2. Name                |
                         |  3. Age                 |
                         |  4. Gender              |
                         |  5. Address             |
                         |  6. Score GPA           |
                         |>-----------------------<|
                        """);
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        System.out.println(" Edit ID: ");
                        String newID = scanner.nextLine().trim();
                        student.setId(newID);
                        break;
                    case 2:
                        System.out.println(" Edit name: ");
                        String newName = scanner.nextLine().trim();
                        student.setName(newName);
                        break;
                    case 3:
                        System.out.println(" Edit age: ");
                        int newAge = Integer.parseInt(scanner.nextLine().trim());
                        student.setAge(newAge);
                        break;
                    case 4:
                        System.out.println(" Edit gender: ");
                        String newGender = scanner.nextLine().trim();
                        student.setGender(newGender);
                        break;
                    case 5:
                        System.out.println(" Edit address: ");
                        String address = scanner.nextLine().trim();
                        student.setAddress(address);
                        break;
                    case 6:
                        System.out.println(" Edit ScoreGPA: ");
                        int scoreGPA = Integer.parseInt(scanner.nextLine().trim());
                        student.setAge(scoreGPA);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                break;

            } else {
                check = false;
            }
        }
        if (!check) {
            System.out.println(" No information in the list...");
        }
    }

    // 4.Delete
    public void delete(String candidates) {
        if (listStudent.removeIf(c -> c.getId().equals(candidates))) {
            System.out.println(" Delete successfully!");
        } else {
            System.out.println(" Candidates not on the list. Can't delete!!!");
        }
    }

    // 5. Sort
    public void sortScoreAscending() {
        Collections.sort(this.listStudent, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getGPA() < o2.getGPA()) {
                    return -1;
                } else if (o1.getGPA() > o2.getGPA()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        displayList();
    }

    public void sortScoreDecrease() {
        Collections.sort(this.listStudent, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getGPA() < o2.getGPA()) {
                    return 1;
                } else if (o1.getGPA() > o2.getGPA()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        displayList();
    }

    // 6. read
    public void readFile(String filePath) {
        String delimiter = ",";
        ArrayList<Student> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Attention: All existing student data in memory will be deleted if you continue!");
            System.out.print("Are you sure you want to continue (Y/N)?");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("Y")) {
                System.out.println("Cancel reading file operation.");
                return;
            }
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                Student sinhVien = new Student(data[0], data[1], Integer.parseInt(data[2]),
                        data[3], data[4], Double.parseDouble(data[5]));
                studentList.add(sinhVien);
            }
            System.out.println("Read list of students from CSV file!");
            System.out.println("Updating memory again...");
            this.listStudent.clear();
            this.listStudent.addAll(studentList);
            // Cập nhật lại bộ nhớ thành công, ghi ra file
            String outputFile = "src\\data\\student.csv";
            FileWriter writer = new FileWriter(outputFile);
            for (Student student : listStudent) {
                String[] data = {
                        student.getId(), student.getName(),
                        Integer.toString(student.getAge()), student.getGender(),
                        student.getAddress(), Double.toString(student.getGPA()) };
                writer.write(String.join(",", data));
                writer.write("\n");
            }
            writer.close();
            System.out.println("Updated the list of students and recorded a CSV file!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 7. Write
    public void writeFile(String filePath, ArrayList<Student> students) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Student student : students) {
                String[] data = { student.getId(), student.getName(), Integer.toString(student.getAge()), student.getGender(), student.getAddress(), Double.toString(student.getGPA()) };
                writer.write(String.join(",", data));
                writer.write("\n");
            }
            System.out.println("Recorded the list of students in the file " + filePath + "!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Student> getListStudents(){
        return listStudent;
    }
}



