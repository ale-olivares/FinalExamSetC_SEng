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
public class category {
    @Id
    @Column(name = "Catcode")
    private String catCode;

    @Column(name = "Catdesc")
    private String catDesc;
}
