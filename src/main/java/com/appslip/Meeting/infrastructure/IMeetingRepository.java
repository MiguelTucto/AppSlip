package com.appslip.Meeting.infrastructure;

import com.appslip.Meeting.domain.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IMeetingRepository extends JpaRepository<Meeting, Long> {
    public List<Meeting> findByNameMeeting(String nameMeeting);
    public List<Meeting> findByDescriptionMeeting(String descriptionMeeting);
    public List<Meeting> findByNumberUsers(Integer numberUsers);
    public List<Meeting> findByCreateAt(Date createAt);
    public List<Meeting> findByCheckingDate(Date checkingDate);
    public List<Meeting> findByCheckoutDate(Date checkoutDate);
}
