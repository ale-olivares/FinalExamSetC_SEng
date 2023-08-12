package com.example.finalexamsetc_seng.repository;

import com.example.finalexamsetc_seng.entities.category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<category, String> {
}
