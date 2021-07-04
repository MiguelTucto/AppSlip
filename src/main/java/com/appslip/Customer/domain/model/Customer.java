package com.appslip.Customer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="firstname", nullable = false, length = 50)
    private String firstName;

    @Column(name="lastname", nullable = false, length = 50)
    private String lastName;

    @Column(name="email", nullable = true, length = 100)
    private String email;

    @Column(name="phone", nullable = true, length = 9)
    private String phone;

    @Column(name="password", nullable = false, length = 50)
    private String password;
}
