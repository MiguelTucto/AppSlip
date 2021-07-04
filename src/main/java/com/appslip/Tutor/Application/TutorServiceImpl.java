package com.appslip.Tutor.Application;

import com.appslip.Tutor.domain.model.ITutorService;
import com.appslip.Tutor.domain.model.Tutor;
import com.appslip.Tutor.infrastructure.ITutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly=true)
public class TutorServiceImpl implements ITutorService {

    @Autowired
    private ITutorRepository tutorRepository;

    @Override
    @Transactional
    public Tutor save(Tutor tutor) throws Exception {
        return tutorRepository.save(tutor);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        tutorRepository.deleteById(id);
    }

    @Override
    public List<Tutor> getAll() throws Exception {
        return tutorRepository.findAll();
    }

    @Override
    public Optional<Tutor> getById(Long Id) throws Exception {
        return tutorRepository.findById(Id);
    }

    @Override
    public List<Tutor> findByFirstName(String firstName) throws Exception {
        return tutorRepository.findByFirstName(firstName);
    }

    @Override
    public List<Tutor> findByLastName(String lastName) throws Exception {
        return tutorRepository.findByLastName(lastName);
    }

    @Override
    public List<Tutor> findByEmail(String email) throws Exception {
        return tutorRepository.findByEmail(email);
    }

    @Override
    public List<Tutor> findByPhone(String phone) throws Exception {
        return tutorRepository.findByPhone(phone);
    }

    @Override
    public List<Tutor> findBySpecialty(String specialty) throws Exception {
        return tutorRepository.findBySpecialty(specialty);
    }

    @Override
    public List<Tutor> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
        return tutorRepository.findByLastNameAndFirstName(lastName, firstName);
    }

    @Override
    public List<Tutor> findByFirstNameAndLastName(String firstName, String lastName) throws Exception {
        return tutorRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
