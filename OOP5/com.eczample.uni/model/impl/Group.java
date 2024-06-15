package model.impl;

import java.util.List;

public class Group {

    public Teacher teacher;
    public List<Student> listOfStudents;

    public int groupId;

    public Group (Teacher teacher, List<Student> listOfStudents, int groupId){
        this.teacher = teacher;
        this.listOfStudents = listOfStudents;
        this.groupId = groupId;
    }

    public String toString() {
        return String.format(getClass().getSimpleName() + ": groupId = %s, %s, listOfStudents = %s", groupId, teacher, listOfStudents);
    }

    public Teacher getTeacher(){
        return teacher;
    }

    public List<Student> getListOfStudents(){
        return listOfStudents;
    }

    public int getGroupId() {
        return groupId;
    }


}
