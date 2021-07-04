package com.appslip.Course.Application;

import com.appslip.Course.domain.model.Course;
import com.appslip.Course.domain.model.ICourseService;
import com.appslip.Course.infrastructure.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly=true)
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Override
    @Transactional
    public Course save(Course course) throws Exception {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getAll() throws Exception {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getById(Long Id) throws Exception {
        return courseRepository.findById(Id);
    }

    @Override
    public List<Course> findByCourseName(String courseName) throws Exception {
        return courseRepository.findByCourseName(courseName);
    }

    @Override
    public List<Course> findByDescriptionCourse(String descriptionCourse) throws Exception {
        return courseRepository.findByDescriptionCourse(descriptionCourse);
    }
}
