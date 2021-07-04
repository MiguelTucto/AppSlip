package com.appslip.Meeting.domain.model;

import com.appslip.Course.domain.model.Course;
import com.appslip.Theme.domain.model.Theme;
import com.appslip.Tutor.domain.model.Tutor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="meeting")
@Data
public class Meeting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="namemeeting", nullable = false, length = 50)
    private String nameMeeting;

    @Column(name = "descriptionmeeting", nullable = true, length = 200)
    private String descriptionMeeting;

    @Column(name = "number_users", nullable = false)
    private Integer numberUsers;

    @Column(name = "create_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "checking_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkingDate;

    @Column(name = "checkout_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkoutDate;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;
}
