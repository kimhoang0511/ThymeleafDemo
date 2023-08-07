package com.example.ThymeleafDemo.Controller;

import com.example.ThymeleafDemo.Services.StudentServices;
import com.example.ThymeleafDemo.models.Students;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(value = "api/version1.0")
public class StudentControllers {
    @Autowired
    private StudentServices studentServices;

    @RequestMapping(value = "laytatcadulieu", method = RequestMethod.GET)
    public List<Students> getAllStudents (){
        return studentServices.getAllStudents();

    }

    @RequestMapping(value = "them1hocsinh", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Students addNewStudent (@RequestBody String studentStr){

        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();


        Students  student = gson.fromJson(studentStr, Students.class);
        return studentServices.addNewStudent(student);
    }

    @RequestMapping(value = "xoahocsinnh", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Students removeStudent (@RequestParam int Id){

        return studentServices.removeStudents(Id);
    }

    @RequestMapping(value = "suahocsinh", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Students remakeStudens (@RequestBody String studentStr){
        Gson gson = new Gson();
        Students  student = gson.fromJson(studentStr, Students.class);
        return studentServices.remakeStudens(student);
    }

    @RequestMapping(value = "laydanhsach", method = RequestMethod.GET)
    public List getAllStudents (@RequestParam int beginId, int endId){
        return studentServices.getListStudents(beginId, endId);


    }

}
