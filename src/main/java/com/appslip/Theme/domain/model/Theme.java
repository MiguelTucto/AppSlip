package com.appslip.Theme.domain.model;

import com.appslip.Course.domain.model.Course;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="theme")
@Data
public class Theme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="themename", nullable = false, length = 100)
    private String themeName;

    @Column(name="descriptiontheme", nullable = false, length = 1000)
    private String descriptionTheme;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
