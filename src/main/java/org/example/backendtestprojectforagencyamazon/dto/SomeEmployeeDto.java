package org.example.backendtestprojectforagencyamazon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;



@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SomeEmployeeDto implements Serializable {
   private String name;
   private String mail;
   private String phoneNumber;
   private String login;
   private String password;



    @Override
    public String toString() {
        return "{" +
               "name:'" + name + '\'' +
               ", mail:'" + mail + '\'' +
               ", phoneNumber:'" + phoneNumber + '\'' +
               ", login:'" + login + '\'' +
               ", password:'" + password + '\'' +
               '}';
    }
}