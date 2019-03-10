package pl.sda.savestudent;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.studentmodel.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nieckarz
 */
public class SaveStudentJson {
    static ObjectMapper mapper = new ObjectMapper();
    static List<Student> listOfStudents = new ArrayList<>();
    static final String file = "listStudents.json";

    public static void saveStudentsList() {
        try {

            String personStr = mapper.writeValueAsString(listOfStudents);
            Files.write(Paths.get(file), personStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        listOfStudents.add(new Student("Noemi","Wspaniała",10));
        listOfStudents.add(new Student("Ania","Kowalska",3));
        listOfStudents.add(new Student("Anita","Jeziorksa",1));
        listOfStudents.add(new Student("Luiza","Jagielonska",4));
        saveStudentsList();

    }

}
