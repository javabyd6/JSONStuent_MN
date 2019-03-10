package pl.sda.readstudent;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.studentmodel.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nieckarz
 */
public class readStudentList {
    static ObjectMapper mapper = new ObjectMapper();
    static List<Student> listOfStudents = new ArrayList<>();
    static final String file = "listStudents.json";

    public static void readStudentsList(){

        try {

            Student[] personArray = mapper.readValue(new File(file), Student[].class);
            listOfStudents = Arrays.asList(personArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void printf(char letter){
        List<Student> lista_osob = listOfStudents.stream().
                filter(t->t.getName().
                        charAt(0)==letter).collect(Collectors.toList());
        System.out.println(lista_osob.toString());
    }

    public static void main(String[] args) {
    readStudentsList();
    System.out.println(listOfStudents.toString());
    printf('A');
    }

}
