package controller;

import model.DB.DataBase;
import model.impl.Group;
import model.impl.Student;
import model.impl.Teacher;
import service.GroupService;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    private GroupService service = new GroupService();

    public Group createGroup(Teacher teacher, List<Student> listOfStudents) {
        return service.createGroup(teacher, listOfStudents);

    }

    public Group createGroupById(int id) {

        List<Student> listOfSudents= new ArrayList<>();
        Teacher teacher = new Teacher();
        Student student = new Student();

        for(Teacher elem : DataBase.teachersDB){
            if(elem.getId() == id){
                teacher = elem;
            }
        }

        for(Student elem : DataBase.studentsDB){
            if(elem.getGroupId() == id){
                listOfSudents.add(elem);
            }
        }

        Group group = null;
        try {
            group = this.createGroup(teacher, listOfSudents);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return group;
    }

    public List<Group> getAllGroups() {
        return service.getAllGroups();
    }
}
