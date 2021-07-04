package com.appslip.Course.domain.model;

import com.appslip.Course.domain.model.Course;
import com.appslip.util.CrudService;

import java.util.List;

public interface ICourseService extends CrudService<Course> {
    public List<Course> findByCourseName(String courseName) throws Exception;
    public List<Course> findByDescriptionCourse(String descriptionCourse) throws Exception;
}
