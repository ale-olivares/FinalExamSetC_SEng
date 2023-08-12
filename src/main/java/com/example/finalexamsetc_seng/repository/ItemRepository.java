package com.example.finalexamsetc_seng.repository;

import com.example.finalexamsetc_seng.entities.items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<items, String> {

}
