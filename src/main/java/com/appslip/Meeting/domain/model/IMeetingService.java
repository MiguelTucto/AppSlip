package com.appslip.Meeting.domain.model;

import com.appslip.Meeting.domain.model.Meeting;
import com.appslip.util.CrudService;

import java.util.Date;
import java.util.List;

public interface IMeetingService extends CrudService<Meeting> {
    public List<Meeting> findByNameMeeting(String nameMeeting) throws Exception;
    public List<Meeting> findByDescriptionMeeting(String descriptionMeeting) throws Exception;
    public List<Meeting> findByNumberUsers(Integer numberUsers) throws Exception;
    public List<Meeting> findByCreateAt(Date createAt) throws Exception;
    public List<Meeting> findByCheckingDate(Date checkingDate) throws Exception;
    public List<Meeting> findByCheckoutDate(Date checkoutDate) throws Exception;
}
