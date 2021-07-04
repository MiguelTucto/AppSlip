package com.appslip.Course.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="coursename", nullable = false, length = 100)
    private String courseName;

    @Column(name="descriptioncourse", nullable = false, length = 1000)
    private String descriptionCourse;

}
