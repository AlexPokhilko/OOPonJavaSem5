package service;

import model.DB.DataBase;
import model.impl.Group;
import model.impl.Student;
import model.impl.Teacher;

import java.util.List;

public class GroupService {

    public Group createGroup(Teacher teacher, List<Student> listOfStudents){// отвечает только за создание студента (чистый метод)

        int groupId = teacher.getId();
        Group group = new Group(teacher, listOfStudents, groupId);

        int id;

        int size = DataBase.groupsDB.size();

        if(size == 0){
            DataBase.groupsDB.add(group);
        } else {
            for (Group elem : DataBase.groupsDB) {
                if (elem.getGroupId() == groupId) {
                    return group;
                }
            }
            DataBase.groupsDB.add(group);
        }
        return group;
    }

    public Student getById(int id) throws Exception {
        Student student = DataBase.studentsDB//список студентов
                .stream()//запускаем поток для вычислений
                // пример лямда-выражения (s -> s.getId() == id)
                .filter(s -> s.getId() == id)//вызываем метод filter фильтруя по условию (s = student(переменная))
                .findFirst()//вернуть первого найденого студента
                .orElse(null);// если не нашли вернуть null (orElse закрывет поток stream)
        if (student == null) {
            throw new Exception("Студент не найден");//выбрасываем проверяемое исключение, которое компилятор требует отработать
        }
        return student;
    }

    public List<Group> getAllGroups(){
        return DataBase.groupsDB;
    }
}
