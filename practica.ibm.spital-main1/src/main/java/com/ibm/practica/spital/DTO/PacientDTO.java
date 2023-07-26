package com.ibm.practica.spital.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacientDTO {

    private String pacientID;
    private String firstName;
    private String lastName;
    private int age;
    private String issue;

}
