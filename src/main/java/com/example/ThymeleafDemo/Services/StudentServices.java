package com.example.ThymeleafDemo.Services;

import com.example.ThymeleafDemo.models.Students;
import com.example.ThymeleafDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices implements IStudentServices{
    @Autowired
    private  StudentRepository studentRepository;

    @Override
    public  List<Students> getAllStudents(){
        return studentRepository.findAll();

    }

    @Override
    public Students addNewStudent(Students student){
        studentRepository.save(student);
        return student;

    }

    @Override
    public Students removeStudents(int Id){
        Optional<Students> student = studentRepository.findById(Id);
        if (student.isEmpty()) return  null;
        studentRepository.delete(student.get());
        return student.get();
    }


    @Override
    public Students remakeStudens(Students studentUpdate) {
        Optional <Students> studentO = studentRepository.findById(studentUpdate.getId());
        if (studentO.isEmpty()) return null;
        Students student = studentO.get();
        student.setTenHocSinh(studentUpdate.getTenHocSinh());
        studentRepository.save(student);
        return  student;
    }

    @Override
    public List getListStudents(int beginId, int endId) {
        if (endId < beginId)
        {
            int temp = beginId;
            beginId = endId;
            endId = temp;
        }
       // List<Students> resulStudents = new ArrayList<>();
        return studentRepository.findByIdBetween( beginId,  endId);

    }
}
