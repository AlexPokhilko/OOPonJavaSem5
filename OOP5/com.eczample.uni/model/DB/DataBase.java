package model.DB;

import java.util.ArrayList;
import java.util.List;

import model.impl.Group;
import model.impl.Student;
import model.impl.Teacher;
//симулирует базу данных
public class DataBase {
    public static final List<Student> studentsDB = new ArrayList<>();

    public static final List<Teacher> teachersDB = new ArrayList<>();

    public static final List<Group> groupsDB = new ArrayList<>();

    public static void fillDB(){
        Teacher teacher1 = new Teacher(1, "Вася", "Иванов");
        Teacher teacher2 = new Teacher(2, "Петя", "Сидоров");
        teacher1.addGroupId(1);
        teacher2.addGroupId(2);
        teachersDB.add(teacher1);
        teachersDB.add(teacher2);
        Student s1 = new Student(1, "Рикон", "Старк", 1);
        Student s2 = new Student(2, "Джофри", "Ланистер", 1);
        Student s3 = new Student(3, "Том", "Сойер", 2);
        Student s4 = new Student(4, "Гекльберри", "Финн", 2);
        studentsDB.add(s1);
        studentsDB.add(s2);
        studentsDB.add(s3);
        studentsDB.add(s4);

    }
}
