package com.appslip.Course.infrastructure;

import com.appslip.Course.domain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
    public List<Course> findByCourseName(String courseName);
    public List<Course> findByDescriptionCourse(String descriptionCourse);
}
