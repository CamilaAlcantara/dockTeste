package com.api.dock.model;

import com.api.dock.model.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "The name cannot be empty")
    private String name;
    @NotEmpty(message = "The lastname cannot be empty")
    private String lastname;
    @Length(min = 11, max = 14)
    private String document ;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate dateRequest;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate updateStatusRequest;
    @Length(min = 9, max = 11)
    private String phone ;
    public String address;
    private StatusEnum status;




}
