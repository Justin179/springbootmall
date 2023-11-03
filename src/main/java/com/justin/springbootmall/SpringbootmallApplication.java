package com.justin.springbootmall;

import com.justin.springbootmall.jpa.relationship.entity.Course;
import com.justin.springbootmall.jpa.relationship.entity.Instructor;
import com.justin.springbootmall.jpa.relationship.entity.InstructorDetail;
import com.justin.springbootmall.jpa.relationship.dao.AppDAO;
import com.justin.springbootmall.jpa.relationship.entity.Review;
import com.justin.springbootmall.jpa.relationship.entity.Student;
import com.justin.springbootmall.jpa.relationship.dao.StudentDAO;
import com.justin.springbootmall.utils.StudentUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmallApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(AppDAO appDAO){
        return runner -> { // will be executed right after the service started

//            createStudent(studentDAO);

//            createStudents(studentDAO);

//            readStudent(studentDAO); // query one

            // query many
//            queryForStudents(studentDAO);

            // query by name
//            queryForStudentsByName(studentDAO, "Omer Moore");

//            updateStudent(studentDAO);

//            deleteStudent(studentDAO);

//            deleteAllStudent(studentDAO);

            // one to one
//            createInstructor(appDAO);

//            findInstructor(appDAO);

//            deleteInstructor(appDAO);

//            findInstructorDetail(appDAO);

//            deleteInstructorDetail(appDAO);

//            createInstructorWithCourses(appDAO);

//            findInstructorWithCourses(appDAO);

//            findInstructorWithCoursesByJoinFetch(appDAO);

//            updateInstructor(appDAO);

//            updateCourse(appDAO);

//            deleteCourseById(appDAO);

//            createCourseAndReviews(appDAO);

//            retrieveCourseAndReviews(appDAO);

//            deleteCourseAndReviews(appDAO);

//            createCourseAndStudents(appDAO);

//            retrieveCourseAndStudents(appDAO);



//            createStudentAndCourses(appDAO);

//            retrieveStudentAndCourses(appDAO);

            addMoreCoursesForStudent(appDAO);
        };
    }

    private void addMoreCoursesForStudent(AppDAO appDAO) {
        int studentId = 3;
        Student student = appDAO.findStudentAndCoursesByStudentId(studentId);
        student.addCourse(new Course("Rubik's cube - how to speed cube"));
        student.addCourse(new Course("Atari 2600 - Game Development"));

        appDAO.update(student);

        System.out.println(student);
        System.out.println(student.getCourses());
    }

    private void retrieveStudentAndCourses(AppDAO appDAO) {
        int studentId = 3;
        Student student = appDAO.findStudentAndCoursesByStudentId(studentId);
        System.out.println(student);
        System.out.println(student.getCourses());
    }

    private void createStudentAndCourses(AppDAO appDAO) {
        Student student = new Student("Ashley", "ashley@gmail.com", 20);
        Course course = new Course("RE2 guide");
        Course course2 = new Course("RE4 guide");
        student.addCourse(course);
        student.addCourse(course2);
        appDAO.save(student);
    }



    private void retrieveCourseAndStudents(AppDAO appDAO) {
        int courseId = 1;
        Course course = appDAO.findCourseAndStudentsByCourseId(courseId);
        System.out.println(course);
        System.out.println(course.getStudents());
    }

    private void createCourseAndStudents(AppDAO appDAO) {
        Course course = new Course("how to properly aim");
        Student student = new Student("john", "doe", 33);
        Student student2 = new Student("Mary", "public", 44);
        course.addStudent(student);
        course.addStudent(student2);
        appDAO.save(course);
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int courseId = 12;

        appDAO.deleteCourseById(courseId);
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        int id = 12;
        Course course = appDAO.findCourseAndReviewsByCourseId(id);
        System.out.println(course);
        System.out.println(course.getReviews());
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        Course course = new Course("how to aim & shoot");
        course.addReview(new Review("well written"));
        course.addReview(new Review("best guide ever"));
        course.addReview(new Review("excellent"));
        appDAO.save(course);
    }

    private void deleteCourseById(AppDAO appDAO) {
        int id = 10;
        appDAO.deleteCourseById(id);
    }

    private void updateCourse(AppDAO appDAO) {
        int courseId = 10;
        Course course = appDAO.findCourseById(courseId);
        course.setTitle("RE4");
        appDAO.update(course);
    }

    private void updateInstructor(AppDAO appDAO) {
        int id = 4;
        Instructor instructor = appDAO.findInstructorById(id);
        instructor.setLastName("RE2");
        appDAO.update(instructor);
    }

    private void findInstructorWithCoursesByJoinFetch(AppDAO appDAO) {
        int id = 4;
        Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int id = 4;
        Instructor instructor = appDAO.findInstructorById(id);
        List<Course> courses = appDAO.findCoursesByInstructorId(id);
        instructor.setCourses(courses);

        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void createInstructorWithCourses(AppDAO appDAO) {

        Instructor instructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");
        instructor.setInstructorDetail(instructorDetail);

        // add courses to the instructor
        Course course = new Course("Air Guitar - The Ultimate Guide");
        Course course2 = new Course("The Pinball Masterclass");
        instructor.add(course);
        instructor.add(course2);

        // save the instructor and its courses and its detail
        appDAO.save(instructor);
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int id = 3;
        appDAO.deleteInstructorDetailById(id);
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int id = 2;
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
        Instructor instructor = instructorDetail.getInstructor();
        System.out.println(instructorDetail);
        System.out.println(instructor);
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 4;
        appDAO.deleteInstructorById(id);
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 2;
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);
        System.out.println(instructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
//        Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//        InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");


        Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Guitar");
        instructor.setInstructorDetail(instructorDetail);

        appDAO.save(instructor);
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("numRowsDeleted: " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 7;
        studentDAO.delete(studentId);
        System.out.println("deleted student id: "+studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student7 = studentDAO.findById(7);
        System.out.println("student7: "+student7);
        student7.setName("Kaede Rukawa");
        studentDAO.update(student7);
        Student updatedStudent7 = studentDAO.findById(7);
        System.out.println("updatedStudent7: "+updatedStudent7);
    }

    private void queryForStudentsByName(StudentDAO studentDAO, String name) {
        List<Student> byName = studentDAO.findByName(name);
        System.out.println(byName);
    }


    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student student: students){
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        Student student = StudentUtils.createOneStudent();
        studentDAO.save(student);
        System.out.println("student saved: "+student);
        Student studentFromDB = studentDAO.findById(student.getId());
        System.out.println("student from DB: "+studentFromDB);
    }

    private void createStudents(StudentDAO studentDAO) {

        // create multiple students
        ArrayList<Student> students = StudentUtils.createStudentList(5);

        // save the student objects
        for (int i = 0; i < students.size(); i++) {
            studentDAO.save(students.get(i));
        }
    }

    private void createStudent(StudentDAO studentDAO) {
        // create object to save
        Student student = StudentUtils.createOneStudent();
        // save the object
        studentDAO.save(student);
        // display id of the saved student
        System.out.println("saved student. Generated id: " + student.getId());

    }

}
