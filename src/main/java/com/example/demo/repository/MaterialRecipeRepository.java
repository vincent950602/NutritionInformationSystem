package com.example.demo.repository;

import com.example.demo.entity.MaterialRecipe;
import com.example.demo.entity.Recipes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaterialRecipeRepository extends JpaRepository<MaterialRecipe, Integer> {

    @Query("select r from MaterialRecipe r")
    Page<MaterialRecipe> findList(Pageable pageable);

    @Query("select r from MaterialRecipe r where r.menuCode = ?1")
    List<MaterialRecipe> findByMenuCode(String menuCode);

}
