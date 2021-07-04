package com.appslip.Tutor.domain.model;

import com.appslip.Tutor.domain.model.Tutor;
import com.appslip.util.CrudService;

import java.util.List;

public interface ITutorService extends CrudService<Tutor> {
    public List<Tutor> findByFirstName(String firstName) throws Exception;
    public List<Tutor> findByLastName(String lastName) throws Exception;
    public List<Tutor> findByEmail(String email) throws Exception;
    public List<Tutor> findByPhone(String phone) throws Exception;
    public List<Tutor> findBySpecialty(String specialty) throws Exception;

    public List<Tutor> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
    public List<Tutor> findByFirstNameAndLastName(String firstName, String lastName) throws Exception;
}
