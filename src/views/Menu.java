package views;

import controller.ManageStudent;
import model.Student;

import java.util.Scanner;

import static java.lang.System.in;

public class Menu {

    public void menu() {
        ManageStudent manageStudent = new ManageStudent();
        Regex regex = new Regex();
// Thêm danh sách có sẵn
//        Student s1 = new Student("MS01","Trần Văn Chung",23,"Male","Mỹ Đình",9);
//        Student s2 = new Student("MS01","Trần Văn Hiếu",23,"Male","Thanh Hoá",6);
//        Student s3 = new Student("MS01","Trần Văn Dũng",23,"Male","Nam Định",7);
//        Student s4 = new Student("MS01","Trần Văn Công",23,"Male"," Hưng Yên",5);
//        Student s5 = new Student("MS01","Trần Văn Hải",23,"Male"," Hà Nam ",8);
//
//        var list = manageStudent.getListStudent();
//        list.add(s1);
//        list.add(s2);
//        list.add(s3);
//        list.add(s4);
//        list.add(s5);

        Scanner scanner = new Scanner(in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("""
                                
                                |>  --><-- MENU --><--  <|
                                || 1. Display all list  ||
                                || 2. Add a contact     ||
                    Please      || 3. update candidate  || 
                     Choice =>  || 4. Delete a contact  ||
                                || 5. Sort by score(GPA)|| 
                                || 6. Read File         ||
                                || 7. Write File        ||
                                ||      0. Exit -->     ||
                                |>======================<|                                         
                                """);
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter the correct format as numbers...");
            }
            switch (choice) {
                case 1: {
                    manageStudent.displayList();
                    break;
                }
                case 2: {
                    int x;
                    do {
                        System.out.println("""
                                |>---------------Please Choice---------------<|
                                |     Do you want to add new contestants?     |
                                |    Please select the corresponding number:  |
                                |          1. Yes / Add candidate ->          |
                                |               2. No / Back <-               |
                                |_____________________________________________|               
                                    """);
                        x = Integer.parseInt(scanner.nextLine().trim());

                        switch (x) {
                            case 1: {

                                try {
                                    System.out.println(" Enter a code student: ");
                                    String code = scanner.nextLine().trim();
                                    while (!regex.validateId(code)) {
                                        System.out.println("Re-enter in the following format: MS01 ");
                                        code = scanner.nextLine().trim();
                                    }

                                    System.out.println(" Enter name: ");
                                    String name = scanner.nextLine().trim();
                                    while (!regex.validateName(name)) {
                                        System.out.println("Re-enter in the following format: Tran Van Chung ");
                                        name = scanner.nextLine().trim();
                                    }

                                    System.out.println(" Enter age:");
                                    int age = Integer.parseInt(scanner.nextLine().trim());

                                    System.out.println(" Enter gender: ");
                                    String gender = scanner.nextLine().trim();

                                    System.out.println(" Please enter addres: ");
                                    String address = scanner.nextLine().trim();

                                    System.out.println(" Enter score GPA: ");
                                    double scoreGPA = Integer.parseInt(scanner.nextLine().trim());

                                    Student s = new Student(code,name,age,gender,address,scoreGPA);
                                    manageStudent.add(s);
                                } catch (NumberFormatException e) {
                                    System.out.println("...Please enter the correct format as numbers...");
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("Returning program...");
                                break;
                            }
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (x != 2);
                }
                break;

                case 3: {
                    System.out.println(" Please enter the correct ID to search:");
                    String id = scanner.nextLine().trim();
                    manageStudent.update(id);
                    break;
                }
                case 4: {
                    System.out.println(" Please enter the correct candidate code to delete: ");
                    String name = scanner.nextLine().trim();
                    manageStudent.delete(name);
                    break;
                }
                case 5: {
                    int sort;
                    do {
                        System.out.println("""
                                            |>--------------<|
                                Please      | 1. Descending. |
                                 Choice =>  | 2. Ascending.  |
                                            | 3. <- Back     |
                                            |________________|
                                            """);
                        sort = Integer.parseInt(scanner.nextLine().trim());
                        switch (sort) {
                            case 1: {
                                System.out.println(" Descending score list is: ");
                                manageStudent.sortScoreDecrease();
                                break;
                            }
                            case 2: {
                                System.out.println(" Ascending score list is: ");
                                manageStudent.sortScoreAscending();
                                break;
                            }
                            case 3: {
                                System.out.println("Returning program...");

                                break;
                            }
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (sort != 3);
                }
                break;
                case 6:{
                    String file = "src\\data\\student.csv";
                    manageStudent.readFile(file);
                    break;}
                case 7:
                    String file = "src\\data\\student.csv";
                    manageStudent.writeFile(file, manageStudent.getListStudents());
                    break;
                case 0:
                    scanner.close();
                default:
                    System.out.println(" Please choose the correct function number sequence above!");
            }
        }
    }
}
