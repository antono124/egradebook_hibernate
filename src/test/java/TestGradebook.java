import com.antogeo.entity.Course;
import com.antogeo.entity.Result;
import com.antogeo.entity.Student;
import com.antogeo.service.CourseService;
import com.antogeo.service.ResultService;
import com.antogeo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*-context.xml")
@Transactional
@Configuration
@ComponentScan("com.antogeo.*")
public class TestGradebook {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ResultService resultService;

    @Test
    public void test(){

        //Insert Student
        Student student = studentService.insert(new Student("student1","123456", new Date()));

        //Test insert results and select
        assertEquals(student.getUsername(), "student1");
        Student retrievedStudent = studentService.getObjectById(student.getStudentId());
        assertEquals(retrievedStudent.getStudentId(),student.getStudentId());

        //TODO student info


        //Insert Course
        Course course = courseService.insert(new Course("Databases", "Introduction to relational Databases", "3"));

        //Test insert course and select
        assertEquals(course.getName(),"Databases");
        long courseId = course.getCourseId();
        Course retrievedCourse = courseService.getObjectById(course.getCourseId());
        assertEquals(retrievedCourse.getCourseId(), courseId);

        //Update Course
        retrievedCourse.setSemester("4");
        Course updatedCourse = courseService.update(retrievedCourse);

        //Test update
        assertEquals(updatedCourse.getSemester(),"4");

        //Enroll student in course
        Result result = new Result(retrievedStudent, updatedCourse);

        //Insert Result
        Result insertedResult = resultService.insert(result);

        //Test insert result
        assertEquals(insertedResult.getStudent(), retrievedStudent);


        //Test select result
        Result retrievedResult = resultService.getObjectById(insertedResult.getResultId());
        assertEquals(retrievedResult.getCourse(), updatedCourse);
        assertEquals(retrievedResult.getStudent(), retrievedStudent);


        //Update Result
        retrievedResult.setGrade(8);
        Result updatedResult = resultService.update(retrievedResult);

        //Test Update
        assertEquals(updatedResult.getGrade(), 8);



        //Delete Entities
        Boolean studentDeleted = studentService.deleteObjectById(retrievedStudent.getStudentId());
        Boolean courseDeleted = courseService.deleteObjectById(updatedCourse.getCourseId());
        Boolean resultDeleted = resultService.deleteObjectById(updatedResult.getResultId());

        //Test Delete
        assertTrue(studentDeleted);
        assertTrue(courseDeleted);
        assertTrue(resultDeleted);
    }



}
