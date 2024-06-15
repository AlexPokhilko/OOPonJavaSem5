package view;

import controller.GroupController;
import controller.StudentController;
import model.DB.DataBase;
import model.impl.Group;
import model.impl.Student;

import java.util.List;
import java.util.Scanner;

public class GroupView {

    private GroupController controller = new GroupController();

    public void start(){
        DataBase.fillDB();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - сформировать группу по id");
            System.out.println("2 - распечатать все сформированные группы");
            System.out.println("3 - выход");

            switch (scanner.nextInt()) {
                case 1 -> createGroupById();
                case 2 -> getAllGroups();
                case 3 -> System.exit(0);// выход из приложения


                default -> System.out.println("Операция не поддерживается");
            }
        }

    }

//    private Student createStudent(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите имя:");
//        String name = scanner.nextLine();
//        System.out.println("Введите фамилию:");
//        String lastName = scanner.nextLine();
//        System.out.println("Введите номер группы:");
//        int groupId = scanner.nextInt();
//        Student student = controller.createStudent(name, lastName, groupId);
//        System.out.println(student);
//        return student;
//
//    };
    private Group createGroupById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id группы: ");
        int id = scanner.nextInt();
        Group group = controller.createGroupById(id);
        System.out.println(group);
        return group;
    };
    private List<Group> getAllGroups(){
        List<Group> groups = controller.getAllGroups();
        for(Group elem : groups){
            System.out.println(elem);
        }

        return groups;
    };

}
