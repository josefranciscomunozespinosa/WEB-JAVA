package es.eoi.jwt.service;

import es.eoi.jwt.model.Course;

import java.util.List;

public interface CourseService
{

    List<Course> all();

    void save( Course course );

    void delete( String courseId );
}
