package com.example.demo.repository;

import com.example.demo.entity.Materials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MaterialRepository extends JpaRepository<Materials,Integer> {

    @Query("select m.price from Materials m where m.materialCode = ?1")
    Integer findByMaterialCode(String materialCode);
}
