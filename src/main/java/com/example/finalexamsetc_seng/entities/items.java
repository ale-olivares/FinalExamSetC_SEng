package com.example.finalexamsetc_seng.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class items {

    @Column(name="Catcode")
    private String catCode;
    @Id
    @Column(name = "lcode")
    private String lCode;
    @Column(name = "ldesc")
    private String lDesc;
    @Column (name="Price")
    private float price;
}
