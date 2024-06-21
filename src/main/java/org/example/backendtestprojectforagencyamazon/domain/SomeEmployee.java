package org.example.backendtestprojectforagencyamazon.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Employee")
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SomeEmployee implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "employee_id")
    private Long id;


    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_mail")

    private String mail;


    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public SomeEmployee(String name, String mail, String phoneNumber, String login, String password) {
        this.name = name;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeEmployee employee = (SomeEmployee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "{" +
               "id:" + id +
               ", name:'" + name + '\'' +
               ", mail:'" + mail + '\'' +
               ", phoneNumber:'" + phoneNumber + '\'' +
               '}';
    }
}
