package com.example.ThymeleafDemo.Services;


import com.example.ThymeleafDemo.models.Students;

import java.util.List;

public interface IStudentServices  {
    public List<Students> getAllStudents();
    public Students addNewStudent(Students student);
    public Students removeStudents(int Id);

    public Students remakeStudens(Students students);
    public List getListStudents (int beginId, int endId);

}