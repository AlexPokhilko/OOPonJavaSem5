package view;

import java.util.List;
import java.util.Scanner;

import controller.StudentController;
import model.DB.DataBase;
import model.impl.Student;

public class StudentView {
    private StudentController controller = new StudentController();

    public void start(){
        DataBase.fillDB();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - создать студента");
            System.out.println("2 - найти студжента по id");
            System.out.println("3 - распечатать информацию о всех студентах");
            System.out.println("4 - выход");

            
            switch (scanner.nextInt()) {
                case 1 -> createStudent();
                case 2 -> getById();
                case 3 -> getAllStudents();
                case 4 -> System.exit(0);// выход из приложения
            
                default -> System.out.println("Операция не поддерживается");
            }
        }

    }

    private Student createStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String lastName = scanner.nextLine();
        System.out.println("Введите номер группы:");
        int groupId = scanner.nextInt();
        Student student = controller.createStudent(name, lastName, groupId);
        System.out.println(student);
        return student;
        
    };
    private Student getById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id пользователя: ");
        int id = scanner.nextInt();
        Student student = controller.getById(id);
        System.out.println(student);
        return student;
    };
    private List<Student> getAllStudents(){
        List<Student> students = controller.getAllStudents();
        System.out.println(students);
        return students;
    };
}
