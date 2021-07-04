package com.appslip.Tutor.infrastructure;

import com.appslip.Tutor.domain.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITutorRepository extends JpaRepository<Tutor, Long> {
    public List<Tutor> findByFirstName(String firstName);
    public List<Tutor> findByLastName(String lastName);
    public List<Tutor> findByEmail(String email);
    public List<Tutor> findByPhone(String phone);
    public List<Tutor> findBySpecialty(String specialty);

    public List<Tutor> findByLastNameAndFirstName(String lastName, String firstName);
    public List<Tutor> findByFirstNameAndLastName(String firstName, String lastName);
}
