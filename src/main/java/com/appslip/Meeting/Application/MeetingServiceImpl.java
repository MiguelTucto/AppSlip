package com.appslip.Meeting.Application;

import com.appslip.Meeting.domain.model.IMeetingService;
import com.appslip.Meeting.domain.model.Meeting;
import com.appslip.Meeting.infrastructure.IMeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly=true)
public class MeetingServiceImpl implements IMeetingService {

    @Autowired
    private IMeetingRepository meetingRepository;

    @Override
    @Transactional
    public Meeting save(Meeting meeting) throws Exception {
        return meetingRepository.save(meeting);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        meetingRepository.deleteById(id);
    }

    @Override
    public List<Meeting> getAll() throws Exception {
        return meetingRepository.findAll();
    }

    @Override
    public Optional<Meeting> getById(Long Id) throws Exception {
        return meetingRepository.findById(Id);
    }

    @Override
    public List<Meeting> findByNameMeeting(String nameMeeting) throws Exception {
        return meetingRepository.findByNameMeeting(nameMeeting);
    }

    @Override
    public List<Meeting> findByDescriptionMeeting(String descriptionMeeting) throws Exception {
        return meetingRepository.findByDescriptionMeeting(descriptionMeeting);
    }

    @Override
    public List<Meeting> findByNumberUsers(Integer numberUsers) throws Exception {
        return meetingRepository.findByNumberUsers(numberUsers);
    }

    @Override
    public List<Meeting> findByCreateAt(Date createAt) throws Exception {
        return meetingRepository.findByCreateAt(createAt);
    }

    @Override
    public List<Meeting> findByCheckingDate(Date checkingDate) throws Exception {
        return meetingRepository.findByCheckingDate(checkingDate);
    }

    @Override
    public List<Meeting> findByCheckoutDate(Date checkoutDate) throws Exception {
        return meetingRepository.findByCheckoutDate(checkoutDate);
    }
}
